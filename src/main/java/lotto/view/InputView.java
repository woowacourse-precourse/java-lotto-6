package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Constants;
import lotto.utils.InputValidator;
import lotto.utils.message.InputMessage;

public class InputView {

    public static int inputAmount() {
        System.out.println(InputMessage.INPUT_AMOUNT.getMessage());
        String input = Console.readLine();
        InputValidator.validateIsNumber(input);
        return Integer.parseInt(input);
    }

    public static String[] inputWinningNumbers() {
        System.out.println(InputMessage.INPUT_WINNING_NUMBERS.getMessage());
        String[] input = Console.readLine().split(Constants.SEPARATOR);
        InputValidator.validateIsAllNumber(input);
        return input;
    }

    public static int inputBonusNumber() {
        System.out.println(InputMessage.INPUT_BONUS_NUMBER.getMessage());
        String input = Console.readLine();
        InputValidator.validateIsNumber(input);
        return Integer.parseInt(input);
    }
}
