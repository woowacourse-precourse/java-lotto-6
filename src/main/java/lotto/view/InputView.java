package lotto.view;

import static lotto.constants.ErrorConstants.INTEGER_CONVERSION_ERROR_MESSAGE;
import static lotto.constants.MessageConstants.INPUT_MESSAGE_FOR_BONUS_NUMBER;
import static lotto.constants.MessageConstants.INPUT_MESSAGE_FOR_BUY_AMOUNT;
import static lotto.constants.MessageConstants.INPUT_MESSAGE_FOR_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getUserInput() {
        return Console.readLine().trim();
    }

    public int getNumberInput() {
        try {
            return Integer.parseInt(getUserInput());
        } catch (Exception e) {
            throw new IllegalArgumentException(INTEGER_CONVERSION_ERROR_MESSAGE.getMessage());
        }
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
