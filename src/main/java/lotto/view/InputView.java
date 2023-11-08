package lotto.view;

import lotto.constant.InputText;

public class InputView {
    public void showAmountInputForm() {
        System.out.println(InputText.REQUEST_TO_INPUT_PURCHASE_AMOUNT.getValue());
    }

    public void showWinningNumbersInputForm() {
        System.out.println(InputText.REQUEST_TO_INPUT_WINNING_NUMBERS.getValue());
    }

    public void showBonusNumberInputForm() {
        System.out.println(InputText.REQUEST_TO_INPUT_BONUS_NUMBER.getValue());
    }

    public void endInput() {
        System.out.println();
    }

    public void showInputErrorMessage(String message) {
        System.out.println(InputText.ERROR_TAG.getValue() + " " + message);
    }
}
