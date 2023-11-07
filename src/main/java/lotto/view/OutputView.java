package lotto.view;

import lotto.config.Rank;
import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String SHOW_LOTTO_CNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String SHOW_RATE_OF_RETURN_MESSAGE = "총 수익률은 %s입니다.\n";
    private static final String SHOW_WINNING_STATISTICS = "당첨 통계\n---";
    private static final String SHOW_WINNING_STATISTICS_DETAILS = "%s - %s개\n";

    private OutputView() {
    }

    public static void showLottoCnt(int lottoCnt) {
        System.out.printf(SHOW_LOTTO_CNT_MESSAGE, lottoCnt);
    }

    public static void showLotto(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void showLottoWinningDetails(List<Integer> winningDetail) {
        System.out.println(SHOW_WINNING_STATISTICS);
        Rank[] ranks = Rank.values();
        for (int i = 0; i < winningDetail.size(); i++) {
            System.out.printf(SHOW_WINNING_STATISTICS_DETAILS, ranks[i].getDesc(), winningDetail.get(i));
        }
    }

    public static void showRateOfReturn(String rateOfReturn) {
        System.out.printf(SHOW_RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }
}
