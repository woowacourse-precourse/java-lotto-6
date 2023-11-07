package lotto.view.result;

import static lotto.common.constant.ErrorConstant.ERROR_PREFIX;
import static lotto.view.constant.CharacterSymbol.BLANK;

import lotto.domain.LottoTickets;
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
    }

}