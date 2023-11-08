package lotto.view;

import lotto.view.constant.OutputMessageConstants;

public class OutputView {
    public void printPurchaseAmountInputMessage() {
        System.out.println(OutputMessageConstants.PURCHASE_AMOUNT_INPUT_MESSAGE);
    }

    public void printWinningNumbersInputMessage() {
        System.out.println(OutputMessageConstants.WINNING_NUMBER_INPUT_MESSAGE);
    }

    public void printBonusNumberInputMessage() {
        System.out.println(OutputMessageConstants.BONUS_NUMBER_INPUT_MESSAGE);
    }
}
