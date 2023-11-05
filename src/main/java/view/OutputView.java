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

    public void newline() {
        printer.println();
    }

    public void printLottoPack(LottoPack lottoPack) {
        printer.println(String.format("%d개를 구매했습니다.", lottoPack.size()));
        printer.println(lottoPack.toString());
    }

    public void printException(Exception exception) {
        printer.println(exception.getMessage());
    }

}
