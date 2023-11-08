package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoGame {
    private List<Integer> winningNumbers;
    private List<Lotto> lottoTickets;
    private List<Integer> result;
    private Integer inputMoney;
    private Integer winningBonusNumber;

    public LottoGame() {
    }

    public void start() {
        boolean isGaming = true;

        while (isGaming) {
            inputMoney = inputMoney();
            System.out.println();

            lottoTickets = generateLottoTickets(inputMoney);
            printTickets();
            System.out.println();

            winningNumbers = inputWinningNumbers().getNumbers();
            winningBonusNumber = inputBonusNumber();
            System.out.println();

            setLottoRanks(lottoTickets, winningNumbers, winningBonusNumber);
            printResult(lottoTickets);

            Integer totalIncome = getMoneyForRank(lottoTickets);
            printRoundedTotalIncome(inputMoney, totalIncome);

            isGaming = false;
        }
    }

    private Integer inputMoney() {
        boolean validInput = false;
        Integer money = 0;

        System.out.println("로또 구입 금액이 얼마인가요?");

        while (!validInput) {
            try {
                money = Integer.valueOf(Console.readLine());
                validateThousandWonUnits(money);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    private void validateThousandWonUnits(Integer money) {
        if (!(money % 1000 == 0)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 천원 단위여야 합니다.");
        }
    }

    private Lotto inputWinningNumbers() {
        Lotto lotto = null;
        String inputNumbers = null;
        boolean validInput = false;

        System.out.println("당첨 번호를 입력해 주세요.");

        while (!validInput) {
            inputNumbers = Console.readLine();
            try {
                lotto = new Lotto(splitByComma(inputNumbers));
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto;
    }

    private Integer inputBonusNumber() {
        String inputNumber;

        System.out.println("보너스 번호를 입력해주세요.");

        inputNumber = Console.readLine();

        winningBonusNumber = Integer.valueOf(inputNumber);

        return winningBonusNumber;
    }

    private List<Integer> splitByComma(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<Lotto> generateLottoTickets(Integer money) {
        List<Lotto> lottos = new ArrayList<>();
        int ticketAmount = (int) money / 1000;

        for (int i = 0; i < ticketAmount; i++) {
            Lotto newLotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(newLotto);
        }

        return lottos;
    }

    private void printTickets() {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoTickets) {
            lotto.printNumbers();
        }
    }

    private void setLottoRanks(List<Lotto> lottoTickets, List<Integer> winningNumbers, Integer bonusNumber) {
        for (Lotto lotto : lottoTickets) {
            lotto.setResultRank(getLottoRank(lotto, winningNumbers, bonusNumber));
        }
    }

    public Integer getLottoRank(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {
        int matchCount = getMatchCount(lotto, winningNumbers);

        if (matchCount == 6) {
            return 1;
        }
        if (matchCount == 5 && isBonusNumberMatch(lotto, bonusNumber)) {
            return 2;
        }
        if (matchCount == 5) {
            return 3;
        }
        if (matchCount == 4) {
            return 4;
        }
        if (matchCount == 3) {
            return 5;
        }
        return 0;
    }

    private Integer getMatchCount(Lotto lotto, List<Integer> winningNumbers) {
        Set<Integer> winningNumberSet = new HashSet<>(winningNumbers);
        return (int) lotto.getNumbers().stream()
                .filter(winningNumberSet::contains)
                .count();
    }

    public boolean isBonusNumberMatch(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public int[] countRanks(List<Lotto> lottoTickets) {
        int[] rankCounts = new int[6]; // 인덱스 1부터 1등 ~ 5등

        for (Lotto lotto : lottoTickets) {
            if (lotto.getResultRank() > 0) {
                rankCounts[lotto.getResultRank()]++;
            }
        }
        return rankCounts;
    }

    private void printResult(List<Lotto> lottoTickets) {
        int[] rankCounts = countRanks(lottoTickets);

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + rankCounts[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + rankCounts[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCounts[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCounts[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCounts[1] + "개");
    }

    private Integer getMoneyForRank(List<Lotto> lottoTickets) {
        Integer totalIncome;
        int[] countRanks = countRanks(lottoTickets);

        totalIncome =
                countRanks[1] * 2000000000 + countRanks[2] * 30000000 + countRanks[3] * 1500000 + countRanks[4] * 50000
                        + countRanks[5] * 5000;

        return totalIncome;
    }

    private void printRoundedTotalIncome(Integer inputMoney, Integer totalIncome) {
        double rateOfReturn = ((totalIncome - inputMoney) / (double) inputMoney) * 100;

        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }
}