package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.constant.CommonSymbol;
import lotto.constant.ExceptionMessage;

public class Parser {

    public static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            ExceptionMessage message = ExceptionMessage.NON_NUMERIC_INPUT_EXCEPTION;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    public static List<Integer> parseToIntListWithComma(String input) {
        validateToIntListWithComma(input);

        return Arrays.stream(input.split(CommonSymbol.COMMA.getSymbol()))
                .map(Parser::parseToInt)
                .toList();
    }

    private static void validateToIntListWithComma(String input) {
        if (input.contains(CommonSymbol.COMMA.getSymbol())) {
            return;
        }

        ExceptionMessage message = ExceptionMessage.NO_COMMA_INPUT_EXCEPTION;
        throw new IllegalArgumentException(message.getMessage());
    }
}
