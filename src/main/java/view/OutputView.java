package view;

import lotto.domain.LottoPack;
import util.Printer.IPrinter;

import static lotto.constant.OutputMessage.BOUGHT_LOTTO_PACK;
import static lotto.constant.OutputMessage.GET_MONEY_MESSAGE;

public class OutputView {

    private final IPrinter printer;

    public OutputView(IPrinter printer) {
        this.printer = printer;
    }

    public void printGetMoney() {
        printer.println(GET_MONEY_MESSAGE.getMessage());
    }

    public void newline() {
        printer.println();
    }

    public void printLottoPack(LottoPack lottoPack) {
        printer.println(buildLottoPackMessage(lottoPack));
        printer.println(lottoPack.toString());
    }

    private String buildLottoPackMessage(LottoPack lottoPack) {
        return String.format(BOUGHT_LOTTO_PACK.getMessage(), lottoPack.size());
    }

    public void printException(Exception exception) {
        printer.println(exception.getMessage());
    }

}
