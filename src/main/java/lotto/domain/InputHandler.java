package lotto.domain;

import lotto.view.InputView;

public class InputHandler {
    //검증하는 부분 추가??
    public static String inputWinningNumber() {
        String inputNumber = InputView.inputWinningLottoNumber();
        return inputNumber;
    }

    public static int inputBonusNumber() {
        int bonus = InputView.inputBonusNumber();
        return bonus;

    }

    public static int inputAmountNumber() {
        return InputView.inputAmount();
    }
}
