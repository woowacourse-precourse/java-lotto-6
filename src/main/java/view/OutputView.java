package view;

import lotto.domain.LottoPack;
import util.Printer.IPrinter;

public class OutputView {

    private final IPrinter printer;

    public OutputView(IPrinter printer) {
        this.printer = printer;
    }

    public void printLottoPack(LottoPack lottoPack) {
        printer.println(lottoPack.toString());
    }

}
