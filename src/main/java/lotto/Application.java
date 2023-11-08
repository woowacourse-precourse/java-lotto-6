package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("구매금액을 입력해 주세요.");
            int buyMoney = Integer.parseInt(Console.readLine().trim());
            if (buyMoney <= 0 || buyMoney % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위의 양수여야 합니다.");
            }
            int count = buyMoney / 1000;
            System.out.println(count + "개를 구매했습니다.");

            List<Lotto> lottos = generateLottos(count);
            Set<Integer> winningNumberSet = promptWinningNumbers();
            int bonusNumber = promptBonusNumber();

            winStatistic(lottos, winningNumberSet, bonusNumber, buyMoney);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해야 합니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            Console.close();
        }
    }

    private static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
            System.out.println(lotto);
        }
        return lottos;
    }

    private static Set<Integer> promptWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        Set<Integer> winningNumberSet = new TreeSet<>();
        String[] selectNumbers = Console.readLine().split(",");
        if (selectNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        for (String selectNumber : selectNumbers) {
            int number = Integer.parseInt(selectNumber.trim());
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1과 45 사이의 숫자여야 합니다.");
            }
            winningNumberSet.add(number);
        }
        if (winningNumberSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
        return winningNumberSet;
    }

    private static int promptBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine().trim());
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다.");
        }
        return bonusNumber;
    }

    static void winStatistic(List<Lotto> lottos, Set<Integer> winningNumberSet, int bonusNumber, int buyMoney) {
        Map<LottoRank, Integer> prizeCount = initializePrizeCount();
        long totalPrize = calculatePrizes(lottos, winningNumberSet, bonusNumber, prizeCount);
        printStatistics(prizeCount, totalPrize, buyMoney);
    }
    private static Map<LottoRank, Integer> initializePrizeCount() {
        Map<LottoRank, Integer> prizeCount = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            prizeCount.put(rank, 0);
        }
        return prizeCount;
    }
    private static long calculatePrizes(List<Lotto> lottos, Set<Integer> winningNumberSet, int bonusNumber, Map<LottoRank, Integer> prizeCount) {
        long totalPrize = 0;
        for (Lotto lotto : lottos) {
            LottoRank rank = determineLottoRank(lotto, winningNumberSet, bonusNumber);
            prizeCount.put(rank, prizeCount.get(rank) + 1);
            totalPrize += rank.getPrizeMoney();
        }
        return totalPrize;
    }
    private static LottoRank determineLottoRank(Lotto lotto, Set<Integer> winningNumberSet, int bonusNumber) {
        int matchCount = 0;
        boolean bonusMatch = false;
        for (int number : lotto.getNumbers()) {
            if (winningNumberSet.contains(number)) {
                matchCount++;
            } else if (number == bonusNumber) {
                bonusMatch = true;
            }
        }
        return LottoRank.valueOf(matchCount, bonusMatch);
    }
    private static void printStatistics(Map<LottoRank, Integer> prizeCount, long totalPrize, int buyMoney) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getPrizeMoney() > 0) { // NONE 타입은 출력하지 않습니다.
                System.out.printf("%d개 일치 (%s원)- %d개%n",
                        rank.getMatchCount(),
                        String.format("%,d", rank.getPrizeMoney()),
                        prizeCount.get(rank));
            }
        }

        double profitRate = ((double) totalPrize / buyMoney) * 100;
        System.out.printf("총 수익률은 %.2f%%입니다.%n", profitRate);
    }

}
