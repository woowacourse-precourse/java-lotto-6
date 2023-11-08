package lotto.view;

import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final int MATCH_NONE = 0;

    public static void printPurchaseComplete(int count) {
        System.out.printf("\n%d개를 구매했습니다.\n", count);
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printWinningStatistics() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    public static void printRankResults(Map<Rank, Integer> winnings) {
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                printSingleRankResult(winnings, rank);
            }
        }
    }

    private static void printSingleRankResult(Map<Rank, Integer> winnings, Rank rank) {
        if (rank == Rank.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s) - %d개\n",
                    rank.getMatchCount(), rank.getPrizeMoneyString(), winnings.getOrDefault(rank, 0));
        } else {
            System.out.printf("%d개 일치 (%s) - %d개\n",
                    rank.getMatchCount(), rank.getPrizeMoneyString(), winnings.getOrDefault(rank, 0));
        }
    }

    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield * 100);
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
