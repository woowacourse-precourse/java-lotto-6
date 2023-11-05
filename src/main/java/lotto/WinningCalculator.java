package lotto;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningNumbers;

public class WinningCalculator {
    public static void calculateAndPrintRanks(List<Lotto> purchasedLottos, WinningNumbers winningNumbers) {
        Rank[] ranks = new Rank[5];

        for (Lotto lotto : purchasedLottos) {
            int matchingCount = countMatchingNumbers(lotto, winningNumbers);
            boolean bonusMatch = isBonusNumberMatching(lotto, winningNumbers);

            Rank rank = calculateRank(matchingCount, bonusMatch);
            if (rank != null) {
                ranks[rank.getRank() - 1] = rank;
            }
        }

        printResults(ranks, purchasedLottos.size());
    }

    private static int countMatchingNumbers(Lotto lotto, WinningNumbers winningNumbers) {
        List<Integer> userNumbers = lotto.getNumbers();
        List<Integer> winningNumbersList = winningNumbers.getWinningNumbers();

        long count = userNumbers.stream().filter(winningNumbersList::contains).count();
        return (int) count;
    }

    private static boolean isBonusNumberMatching(Lotto lotto, WinningNumbers winningNumbers) {
        int userBonusNumber = lotto.getNumbers().get(5);
        int bonusNumber = winningNumbers.getBonusNumber();
        return userBonusNumber == bonusNumber;
    }

    private static Rank calculateRank(int matchingCount, boolean bonusMatch) {
        if (matchingCount == 6) {
            return new Rank(1, 2_000_000_000L, 1, matchingCount);
        } else if (matchingCount == 5 && bonusMatch) {
            return new Rank(2, 30_000_000L, 1, matchingCount);
        } else if (matchingCount == 5) {
            return new Rank(3, 1_500_000L, 1, matchingCount);
        } else if (matchingCount == 4) {
            return new Rank(4, 50_000L, 1, matchingCount);
        } else if (matchingCount == 3) {
            return new Rank(5, 5_000L, 1, matchingCount);
        } else {
            return null;
        }
    }


    private static void printResults(Rank[] ranks, int totalLottos) {
        System.out.println("당첨 통계");
        System.out.println("---");

        boolean hasWinner = false;

        for (Rank rank : ranks) {
            if (rank != null) {
                hasWinner = true;
                System.out.printf("%d개 일치 (%,d원) - %d개%n", rank.getMatchingCount(), rank.getAmount(), rank.getCount());
            }
        }

        if (!hasWinner) {
            System.out.println("당첨된 내역이 없습니다.");
        }

        double profitRate = calculateProfitRate(ranks, totalLottos);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private static double calculateProfitRate(Rank[] ranks, int totalLottos) {
        double totalPrize = 0;
        for (Rank rank : ranks) {
            if (rank != null) {
                totalPrize += rank.getAmount() * rank.getCount();
            }
        }
        return ((totalPrize - totalLottos * 1000) / (double) (totalLottos * 1000)) * 100;
    }
}
