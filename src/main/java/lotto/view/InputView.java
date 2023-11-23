package lotto.view;

import java.util.List;
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

    public List<Integer> getLottoNumbers() {
        printer.printMessage("당첨 번호를 입력해 주세요.");
        return reader.getIntegers(",");
    }

    public int getBonusNumber() {
        printer.printMessage("보너스 번호를 입력해 주세요.");
        return reader.getInteger();
    }
}
