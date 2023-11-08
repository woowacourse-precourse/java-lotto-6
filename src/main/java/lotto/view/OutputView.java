package lotto.view;

import java.util.List;
import lotto.constants.GameMessage;
public class OutputView {
    public static void printPayInputMessage() {
        System.out.println(GameMessage.PAY_INPUT_MESSAGE.getMessage());
    }

    public static void printPayOutputMessage(int count) {
        System.out.printf(GameMessage.PAY_OUTPUT_MESSAGE.getMessage(), count);
        System.out.println();
    }

    public static void printNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printWinningNumberMessage() {
        System.out.println(GameMessage.WINNING_NUMBER_MESSAGE.getMessage());
    }

    public static void printBonusNumberMessage() {
        System.out.println(GameMessage.BONUS_NUMBER_MESSAGE.getMessage());
    }
}
