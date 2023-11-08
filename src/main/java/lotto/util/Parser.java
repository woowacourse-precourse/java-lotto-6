package lotto.util;

import static lotto.constant.MessageConstants.CANNOT_INSTANTIATE;
import static lotto.constant.NumberConstants.SPLIT_SEPARATOR;

import java.util.List;
import lotto.validator.ParserValidator;

public class Parser {

    private Parser() {
        throw new AssertionError(CANNOT_INSTANTIATE);
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
        return List.of(numberString.split(SPLIT_SEPARATOR));
    }

}
