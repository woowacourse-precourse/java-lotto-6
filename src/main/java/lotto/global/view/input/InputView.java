package lotto.global.view.input;

import camp.nextstep.edu.missionutils.Console;

import static lotto.global.constant.exception.ExceptionMessage.INPUT_MUST_BE_NUMBER;

public class InputView {

    public static String input() {
        return Console.readLine();
    }

    public static int inputInteger() {
        try {
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_MUST_BE_NUMBER.getMessage());
        }

    }

}
