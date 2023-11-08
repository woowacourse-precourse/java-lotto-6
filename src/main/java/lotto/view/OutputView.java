package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.ProfitCalculator;
import lotto.model.WinningRank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PURCHASED_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_HEAD_MESSAGE = "당첨 통계" + "\n---";
    private static final String RESULT_EACH_RANK_MESSAGE = "%s개 일치 (%,d원) - %d개\n";
    private static final String RESULT_SECOND_RANK_MESSAGE = "%s개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String PROFITRATE_MESSAGE = "\n총 수익률은 %.2f%%입니다.\n";

    public static void printPurchaseResult(long tickets, List<Lotto> lottoTickets) {
        System.out.println("\n" + tickets + PURCHASED_MESSAGE);
        printLottoTickets(lottoTickets);
    }
    public static void printLottoTickets(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers().toString());
        }
        System.out.println();
    }

    public static void printResult(LottoResult lottoResult, long purchasedAmount) {
        System.out.println(RESULT_HEAD_MESSAGE);

        Map<WinningRank, Integer> rankCounts = lottoResult.getRankCounts();

        for (WinningRank rank : WinningRank.values()) {
            int count = rankCounts.get(rank);
            printEachResult(rank, count);
        }

        printProfitRate(purchasedAmount, lottoResult.getTotalReward());
    }

    public static void printEachResult(WinningRank rank, int count) {
        int matchedCount = rank.getMatchCount();
        long prize = rank.getPrize();

        if (rank == WinningRank.SECOND) {
            System.out.printf(RESULT_SECOND_RANK_MESSAGE, matchedCount, prize, count);
        }
        System.out.printf(RESULT_EACH_RANK_MESSAGE, matchedCount, prize, count);
    }

    public static void printProfitRate(long purchasedAmount, long totalAmount) {
        double profitRate = ProfitCalculator.calculate(purchasedAmount, totalAmount);
        System.out.printf(PROFITRATE_MESSAGE, profitRate);
    }
}
