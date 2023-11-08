package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;

public class OutputView {
    private static final String PURCHASED_LOTTO_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계\n---------";
    private static final String WINNING_RANK_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String WINNING_RANK_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.printf(PURCHASED_LOTTO_MESSAGE, lottoTickets.getNumberOfTickets());
        for (Lotto lotto : lottoTickets.getTickets()) {
            printLotto(lotto);
        }
        System.out.println();
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printWinningResult(LottoResult lottoResult) {
        System.out.println(WINNING_STATISTICS_HEADER);
        for (int i = LottoRank.values().length - 1; i >= 0; i--) {
            LottoRank rank = LottoRank.values()[i];
            printRankResult(lottoResult, rank);
        }
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }

    private static void printRankResult(LottoResult lottoResult, LottoRank rank) {
        int count = lottoResult.getCountOfRank(rank);
        if (rank == LottoRank.NONE) {
            return;
        }
        System.out.println(formatRankResult(rank, count));
    }

    private static String formatRankResult(LottoRank rank, int count) {
        String prizeFormatted = String.format("%,d", rank.getPrize());
        if (rank == LottoRank.SECOND) {
            return String.format(WINNING_RANK_BONUS_MESSAGE, rank.getMatchingNumbers(), prizeFormatted, count);
        }
        return String.format(WINNING_RANK_MESSAGE, rank.getMatchingNumbers(), prizeFormatted, count);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
