package lotto.view.result;

import static lotto.common.constant.ErrorConstant.ERROR_PREFIX;
import static lotto.view.constant.CharacterSymbol.BLANK;
import static lotto.view.result.ResultGuideMessage.RESULT_PRIZE_GUIDE;

import lotto.domain.LottoTickets;
import lotto.domain.profit.LottoProfitRate;
import lotto.domain.result.LottoPrizeResult;
import lotto.view.printer.Printer;

public class ResultView {

    private final Printer printer;
    private final ResultViewFormatter formatter;

    public ResultView(Printer printer, ResultViewFormatter formatter) {
        this.printer = printer;
        this.formatter = formatter;
    }

    public void showErrorMessage(String errorMessage) {
        printer.printLine(ERROR_PREFIX + BLANK.getLiteral() + errorMessage);
    }

    public void showPurchasedLottoTickets(LottoTickets tickets) {
        printer.printEmptyLine();
        printer.printLine(formatter.toLottoPurchaseQuantityFormat(tickets.getSize()));
        printer.printLine(formatter.toLottoNumberPrintFormat(tickets.getTickets()));
        printer.printEmptyLine();
    }

    public void showPrizeResult(LottoPrizeResult prizeResult) {
        printer.printLine(RESULT_PRIZE_GUIDE.getGuide());
        printer.printLine(formatter.toPrizeResultFormat(prizeResult));
    }

    public void showProfitRate(LottoProfitRate profitRate) {
        printer.printLine(formatter.toProfitRateFormat(profitRate));
    }

}