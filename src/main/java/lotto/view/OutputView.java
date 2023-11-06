package lotto.view;

import lotto.domain.LottoTickets;
import lotto.view.printer.Printer;

public class OutputView {

    private final Printer printer;
    private final PrintFormatter formatter;

    public OutputView(Printer printer, PrintFormatter formatter) {
        this.printer = printer;
        this.formatter = formatter;
    }

    public void showErrorMessage(String errorMessage) {
        printer.printLine(errorMessage);
    }

    public void showPurchasedLottoTickets(LottoTickets tickets) {
        printer.printEmptyLine();
        printer.printLine(formatter.toLottoPurchaseQuantityFormat(tickets.getSize()));
        printer.printLine(formatter.toLottoNumberPrintFormat(tickets.getTickets()));
    }

}