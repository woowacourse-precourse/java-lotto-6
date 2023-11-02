package lotto.view;

import lotto.domain.constants.OutputViewMessage;

public class OutputView {

    public void printInputMoneyMessage() {
        System.out.println(OutputViewMessage.INPUT_MONEY_MESSAGE.getMessage());
    }

    public void printInputWinningNumbersMessage() {
        System.out.println(OutputViewMessage.INPUT_WINNING_NUMBERS.getMessage());
    }
}
