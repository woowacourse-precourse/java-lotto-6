package lotto.view;

import static lotto.view.InputUtil.*;

public class InputView {
    public String inputMoney() {
        return readNaturalNumber();
    }

    public String inputWinningNumber() {
        return readString();
    }

    public String inputBonusNumber() {
        return readNaturalNumber();
    }
}
