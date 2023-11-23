package lotto.view;

import lotto.view.io.Printer;
import lotto.view.io.Reader;

public class InputView {
    public static final String MESSAGE_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    Reader reader = new Reader();
    Printer printer = new Printer();

    public int getPurchaseMoney() {
        printer.printMessage(MESSAGE_PURCHASE_MONEY);
        return reader.getInteger();
    }
}
