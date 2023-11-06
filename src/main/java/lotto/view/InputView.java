package lotto.view;

import lotto.utils.Constants;

public class InputView {
    private static final InputView inputView = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return inputView;
    }

    public void printPurchaseMoneyMessage() {
        System.out.println(Constants.REQUEST_INPUT_PURCHASE_MONEY_MESSAGE);
    }

    public void printWinningNumbersMessage() {
        System.out.println(Constants.REQUEST_INPUT_WINNING_NUMBER_MESSAGE);
    }

    public void printWinningBonusNumberMessage() {
        System.out.println(Constants.REQUEST_INPUT_BONUS_NUMBER_MESSAGE);
    }
}