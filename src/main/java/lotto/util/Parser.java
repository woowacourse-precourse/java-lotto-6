package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.constant.CommonSymbol;
import lotto.validation.InputValidator;

public class Parser {

    public static int parseToInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> parseToIntListWithComma(String input) {
        validateToIntListWithComma(input);
        
        return Arrays.stream(input.split(CommonSymbol.COMMA.getSymbol()))
                .map(Parser::parseToInt)
                .toList();
    }

    private static void validateToIntListWithComma(String input) {
        Arrays.stream(input.split(CommonSymbol.COMMA.getSymbol()))
                .forEach(InputValidator::validateNumericInput);
    }
}
