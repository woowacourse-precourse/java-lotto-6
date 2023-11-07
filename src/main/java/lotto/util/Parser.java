package lotto.util;

import java.util.List;
import lotto.validator.ParserValidator;

public class Parser {

    private Parser() {
        throw new AssertionError("인스턴스화 불가능");
    }

    public static List<Integer> parseStringToInteger(String numberString) {
        List<String> splitNumbers = split(numberString);
        ParserValidator parserValidator = new ParserValidator(splitNumbers);
        parserValidator.validateAll();

        return splitNumbers.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    private static List<String> split(String numberString) {
        return List.of(numberString.split(","));
    }

}
