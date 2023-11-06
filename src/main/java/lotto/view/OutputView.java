package lotto.view;

import static lotto.util.message.ViewMessages.INPUT_BONUS_NUMBER;
import static lotto.util.message.ViewMessages.INPUT_USER_MONEY;
import static lotto.util.message.ViewMessages.INPUT_WINNING_NUMBERS;

public class OutputView {
    public void printUserMoneyInputGuide() {
        println(INPUT_USER_MONEY);
    }

    public void printWinningNumbersGuide() {
        println(INPUT_WINNING_NUMBERS);
    }

    public void printBonusNumberGuide() {
        println(INPUT_BONUS_NUMBER);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
