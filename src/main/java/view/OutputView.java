package view;

import lotto.domain.LottoPack;
import util.Printer.IPrinter;

public class OutputView {

    private final IPrinter printer;

    public OutputView(IPrinter printer) {
        this.printer = printer;
    }

    public void printGetMoney() {
        printer.println("구입금액을 입력해 주세요.");
    }

    public void printLottoPack(LottoPack lottoPack) {
        printer.println(lottoPack.toString());
    }

    public void printException(Exception exception) {
        printer.println(exception.getMessage());
    }

}
