package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.ErrorMessage.NOT_NUMBER;

public class InputView {
    public static String inputIntegerData() {
        String input = readLine();
        validateParseLong(input);
        return input;
    }

    private static void validateParseLong(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }
}
