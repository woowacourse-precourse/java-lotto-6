package lotto.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningDetails;
import lotto.model.WinningSummary;

public class OutputView {

    private static final String LOTTO_PURCHASE_FORMAT = "\n%d개를 구매했습니다.";

    private static final String MATCH_COUNT_FORMAT = "%d개 일치";
    private static final String BONUS_MATCH_FORMAT = ", 보너스 볼 일치";
    private static final String TOTAL_AMOUNT_FORMAT = " (%,d원)";
    private static final String RANK_MATCH_COUNT_FORMAT = " - %d개";

    private static final String WINNING_DETAILS_HEADER = "\n당첨 통계";
    private static final String WINNING_DETAILS_LINE = "---";

    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %s%%입니다.";
    private static final DecimalFormat RATE_PRECISION_FORMAT = new DecimalFormat(",##0.0");

    // 기본 생성자가 만들어지는 것을 막는다. (인스턴스화 방지용).
    private OutputView() {
        throw new AssertionError();
    }

    public static void printLottoTickets(final List<Lotto> lottoTickets) {
        System.out.printf((LOTTO_PURCHASE_FORMAT) + "%n", lottoTickets.size());
        for (final Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public static void printWinningDetails(final WinningDetails winningDetails) {
        System.out.println(WINNING_DETAILS_HEADER);
        System.out.println(WINNING_DETAILS_LINE);

        for (final WinningSummary summary : winningDetails.getResults()) {
            printWinningSummary(summary);
        }
    }

    private static void printWinningSummary(final WinningSummary summary) {
        final StringBuilder message = new StringBuilder();
        message.append(String.format(MATCH_COUNT_FORMAT, summary.numberOfMatches()));

        if (summary.containsBonus()) {
            message.append(BONUS_MATCH_FORMAT);
        }
        message.append(String.format(TOTAL_AMOUNT_FORMAT, summary.prize()));
        message.append(String.format(RANK_MATCH_COUNT_FORMAT, summary.frequency()));
        System.out.println(message);
    }

    public static void printProfitRate(final BigDecimal profitRate) {
        final String formattedRate = RATE_PRECISION_FORMAT.format(profitRate.doubleValue());
        System.out.printf(PROFIT_RATE_FORMAT + "%n", formattedRate);
    }
}
