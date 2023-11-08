package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {

    public LottoController() {
    }

    void play() {
        int LottoNum = moneyInput();
        List<Lotto> LottoList = buyLotto(LottoNum);
        List<Integer> WinningNum = winningNumInput();
        int BonusNum = bonusNumInput();
        RatingCalculate(LottoList, WinningNum, BonusNum);
    }

    private void EarningCalculate(int[] rankCounts, int lottoCount) {
        int totalPrize = 0;
        for (int i = 0; i < Rank.values().length - 1; i++) {
            totalPrize += rankCounts[i] * Rank.values()[i].getPrize();
        }

        int totalSpent = lottoCount * 1000;
        double earningRate = (double) totalPrize / totalSpent * 100;

        System.out.println("총 수익률은 " + String.format("%.1f", earningRate) + "%입니다.");
    }

    private void RatingCalculate(List<Lotto> lottoList, List<Integer> winningNum, int bonusNum) {
        int[] rankCounts = new int[Rank.values().length];
        int lottoPrice = 1000;

        for (Lotto lotto : lottoList) {
            int matchingCount = countMatchingNumbers(lotto.getNumbers(), winningNum);
            boolean hasBonusBall = lotto.getNumbers().contains(bonusNum);
            Rank rank = findRank(matchingCount, hasBonusBall);
            rankCounts[rank.ordinal()]++;
        }

        printWinningStatistics(rankCounts);

        int lottoCount = lottoList.size(); // 구입한 로또 개수
        EarningCalculate(rankCounts, lottoCount);
    }

    private static void printWinningStatistics(int[] rankCounts) {
        System.out.println("당첨 통계\n---");
        for (int i = Rank.values().length - 2; i >= 0; i--) {
            Rank rank = Rank.values()[i];
            int count = rankCounts[i];
            System.out.println(rank.getDescription() + " - " + count + "개");
        }
    }

    public enum Rank {
        FIRST(6, 2_000_000_000, "6개 일치"), SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"), THIRD(5, 1_500_000, "5개 일치"), FOURTH(4, 50_000, "4개 일치"), FIFTH(3, 5_000, "3개 일치"), NO_RANK(0, 0, "꽝");

        private final int matchCount;
        private final int prize;
        private final String description;

        Rank(int matchCount, int prize, String description) {
            this.matchCount = matchCount;
            this.prize = prize;
            this.description = description;
        }

        public int getPrize() {
            return prize;
        }

        public String getDescription() {
            return description + " (" + String.format("%,d원", prize) + ")";
        }
    }

    private int countMatchingNumbers(List<Integer> userNumbers, List<Integer> winningNumbers) {
        return (int) userNumbers.stream().filter(winningNumbers::contains).count();
    }

    private Rank findRank(int matchingCount, boolean hasBonusBall) {
        if (matchingCount == 6) return Rank.FIRST;
        if (matchingCount == 5) {
            if (hasBonusBall) return Rank.SECOND;
            return Rank.THIRD;
        }
        if (matchingCount == 4) return Rank.FOURTH;
        if (matchingCount == 3) return Rank.FIFTH;
        return Rank.NO_RANK;
    }

    private List<Lotto> buyLotto(int lottoNum) {
        List<Lotto> LottoList = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            List<Integer> list = makeRandomNum();
            Lotto lotto = new Lotto(list);
            LottoList.add(lotto);
        }
        printLottoList(LottoList);
        return LottoList;
    }

    private static void printLottoList(List<Lotto> LottoList) {
        for (Lotto lotto : LottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    private List<Integer> makeRandomNum() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    private int moneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        int Money = moneyInputValidTest();
        int LottoNum = Money / 1000;
        System.out.println(LottoNum + "개를 구매했습니다.");
        return LottoNum;
    }

    private int moneyInputValidTest() {
        while (true) {
            try {
                int Money = Integer.parseInt(readLine());
                if (Money % 1000 != 0) throw new IllegalArgumentException();
                return Money;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR]유효한 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]1000원 단위로 입력해 주세요.");
            }
        }
    }


    private int bonusNumInput() {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                int bonusNum = Integer.parseInt(readLine());
                if (bonusNum > 45 || bonusNum < 1) throw new IllegalArgumentException();
                return bonusNum;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR]유효한 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]보너스 번호는 1~45 사이의 숫자만 가능합니다.");
            }
        }
    }

    private List<Integer> winningNumInput() {
            while (true) {
                try {
                    System.out.println("당첨 번호를 입력해 주세요.");
                    List<Integer> WinningNum = Arrays.stream(readLine().split(","))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());

                    if (WinningNum.size() != 6) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
                    }

                    Set<Integer> checkSameNum = new HashSet<>(WinningNum);
                    if (checkSameNum.size() != 6) {
                        throw new IllegalArgumentException("[ERROR]동일한 로또 번호가 있으면 안됩니다.");
                    }

                    for (int number : WinningNum) {
                        if (number < 1 || number > 45) {
                            throw new IllegalArgumentException("[ERROR]로또 번호는 1~45 사이의 숫자만 가능합니다.");
                        }
                    }

                    return WinningNum;
                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR]로또 번호는 숫자만 가능합니다.");
                }
            }
        }
    }


