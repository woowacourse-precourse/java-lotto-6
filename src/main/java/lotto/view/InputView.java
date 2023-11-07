package lotto.view;

import static lotto.view.MessageConstants.INPUT_MESSAGE_FOR_BONUS_NUMBER;
import static lotto.view.MessageConstants.INPUT_MESSAGE_FOR_BUY_AMOUNT;
import static lotto.view.MessageConstants.INPUT_MESSAGE_FOR_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getUserInput() {
        return Console.readLine().trim();
    }

    public void printBuyAmountInput() {
        System.out.println(INPUT_MESSAGE_FOR_BUY_AMOUNT);
    }

    public void printWinningNumbersInput() {
        System.out.println(INPUT_MESSAGE_FOR_WINNING_NUMBERS);
    }

    public void printBonusNumberInput() {
        System.out.println(INPUT_MESSAGE_FOR_BONUS_NUMBER);
    }
}
