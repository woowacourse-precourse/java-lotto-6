package lotto.view;

import lotto.constant.InputInstruction;

public class InputView {
    public void showAmountInputForm() {
        System.out.println(InputInstruction.REQUEST_TO_INPUT_PURCHASE_AMOUNT.getInstruction());
    }

    public void showWinningNumbersInputForm() {
        System.out.println(InputInstruction.REQUEST_TO_INPUT_WINNING_NUMBERS.getInstruction());
    }

    public void showBonusNumberInputForm() {
        System.out.println(InputInstruction.REQUEST_TO_INPUT_BONUS_NUMBER.getInstruction());
    }

    public void endInput() {
        System.out.println();
    }

    public void showInputErrorMessage(String message) {
        System.out.println(InputInstruction.ERROR_TAG.getInstruction() + " " + message);
    }
}
