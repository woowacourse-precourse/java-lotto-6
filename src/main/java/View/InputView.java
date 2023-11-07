package View;

import static util.ProgressMessage.INPUT_AMOUNT;
import static util.ProgressMessage.INPUT_BONUS_NUMBER;
import static util.ProgressMessage.INPUT_WINNING_NUMBERS;

public class InputView {

    public static void buyMessage() {
        System.out.println(INPUT_AMOUNT.get());
    }

    public static void winningNumbersMessage() {
        System.out.println(INPUT_WINNING_NUMBERS.get());
    }

    public static void bonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER.get());
    }
}
