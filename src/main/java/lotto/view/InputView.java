package lotto.view;

import lotto.view.util.InputUtil;

public class InputView {
    private final InputUtil inputUtil;

    public InputView(InputUtil inputUtil) {
        this.inputUtil = inputUtil;
    }

    public int inputMoney() {
        return inputUtil.readNaturalNumber();
    }

    public String inputWinningNumber() {
        return inputUtil.readString();
    }

    public int inputBonusNumber() {
        return inputUtil.readNaturalNumber();
    }
}
