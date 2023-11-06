package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Profit;
import lotto.enums.Rank;

public class OutputView {
    private static final String INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String RATE_FORMAT = "#,##0.0";

    private OutputView() {
    }

    public static void printPurchaseMessage() {
        System.out.println(INPUT_PURCHASE_PRICE);
    }

    public static void printPurchaseCount(LottoTicket lottoTicket) {
        System.out.printf("%d개를 구매했습니다.", lottoTicket.getLottoCount());
        printNewLine();
    }

    public static void printPurchaseLottoTickets(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.getPrintedLottoTicket());
    }

    public static void printWinningNumberMessage() {
        System.out.println(INPUT_WINNING_NUMBER);
    }

    public static void printBonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void printWinningResult(LottoResult lottoResult) {
        System.out.println(WINNING_STATISTICS);
        Arrays.stream(Rank.values())
                .forEach(rank -> System.out.printf(rank.getMatchInfo(), lottoResult.findMatchCountFor(rank)));
        printNewLine();
    }

    public static void printRateOfReturn(Profit profit) {
        DecimalFormat df = new DecimalFormat(RATE_FORMAT);
        System.out.printf("총 수익률은 %s%%입니다.", df.format(profit.getRateOfReturn()));
    }

    public static void printErrorMessageFor(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public static void printNewLine() {
        System.out.println();
    }
}
