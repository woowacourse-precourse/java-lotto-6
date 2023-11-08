package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.ProfitCalculator;
import lotto.model.WinningRank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PURCHASED_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_HEAD_MESSAGE = "\n당첨 통계" + "\n---";
    private static final String RESULT_EACH_RANK_MESSAGE = "%s개 일치 (%,d원) - %d개\n";
    private static final String RESULT_SECOND_RANK_MESSAGE = "%s개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String PROFITRATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public static void printPurchaseResult(long tickets, List<Lotto> lottoTickets) {
        System.out.println("\n" + tickets + PURCHASED_MESSAGE);
        printLottoTickets(lottoTickets);
    }
    private static void printLottoTickets(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers().toString());
        }
        System.out.println();
    }

    public static void printResult(LottoResult lottoResult, long purchasedAmount) {
        System.out.println(RESULT_HEAD_MESSAGE);

        WinningRank[] ranks = WinningRank.values();
        int rankCount = ranks.length;

        //역순 출력
        for (int i = rankCount - 1; i >= 0; i--) {
            WinningRank rank = ranks[i];
            int count = lottoResult.getCountByRank(rank);
            printEachResult(rank, count);
        }

        printProfitRate(purchasedAmount, lottoResult.getTotalReward());
    }

    private static void printEachResult(WinningRank rank, int count) {
        int matchedCount = rank.getMatchCount();
        long prize = rank.getPrize();

        if (rank == WinningRank.SECOND) {
            System.out.printf(RESULT_SECOND_RANK_MESSAGE, matchedCount, prize, count);
        }
        if (rank == WinningRank.NONE) {
            return;
        }
        if (rank != WinningRank.SECOND)
        System.out.printf(RESULT_EACH_RANK_MESSAGE, matchedCount, prize, count);
    }

    private static void printProfitRate(long purchasedAmount, long totalAmount) {
        double profitRate = ProfitCalculator.calculate(purchasedAmount, totalAmount);
        System.out.printf(PROFITRATE_MESSAGE, profitRate);
    }
}
