package lotto.generator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningStatistic {

    public static void printWinningStatistic(int count, List<List<Integer>> ticketBundle, List<Integer> winningNumbers, int bonusNumber) {
        int[] winningCount = new int[7];

        for (List<Integer> ticket : ticketBundle) {
            int countOfMatch = countMatchingNumbers(ticket, winningNumbers, bonusNumber);
            updateWinningCount(winningCount, countOfMatch);
        }

        printStatistics(winningCount, count);
    }

    public static int countMatchingNumbers(List<Integer> ticket, List<Integer> winningNumbers, int bonusNumber) {
        Set<Integer> winningSet = new HashSet<>(winningNumbers);
        int countOfMatch = 0;
        for (int number : ticket) {
            if (winningSet.contains(number)) {
                countOfMatch++;
            }
        }

        return determineMatchingResult(countOfMatch, bonusNumber);
    }


    public static int determineMatchingResult(int countOfMatch, int bonusNumber) {
        if (countOfMatch == 6 && bonusNumber != -1) {
            return 5; // 5개 일치, 보너스 볼 일치
        }
        if (countOfMatch == 6) {
            return 6; // 6개 일치, 보너스 볼 불일치
        }
        return countOfMatch; // 그 외 일치 수
    }


    public static void updateWinningCount(int[] winningCount, int countOfMatch) {
        winningCount[countOfMatch]++;
    }

    public static int calculateTotalPrize(int[] winningCount) {
        int[] prizes = {0, 0, 5000, 50000, 1500000, 30000000, 2000000000};
        int totalPrize = 0;
        for (int i = 2; i < 7; i++) {
            totalPrize += (winningCount[i] * prizes[i]);
            System.out.println(winningCount[i] + "개 일치 (" + prizes[i] + ") - " + winningCount[i] + "개");
        }
        return totalPrize;
    }

    public static void printStatistics(int[] winningCount, int count) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winningCount[2] + "개");
        System.out.println("4개 일치 (50,000원) - " + winningCount[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + (winningCount[4] - winningCount[5]) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningCount[5] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningCount[6] + "개");

        double totalPrize = calculateTotalPrize(winningCount);
        double totalInvestment = count * 1000;
        double profitRatio = (totalPrize / totalInvestment) * 100;

        System.out.printf("\n총 수익률은 %.1f%% 입니다.", profitRatio);
    }


    public static void printPrizeLevel(int matchingNumbers, String prize, int count) {
        System.out.println(matchingNumbers + "개 일치 (" + prize + ") - " + count + "개");
    }
}
