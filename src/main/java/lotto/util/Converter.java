package lotto.util;

import static lotto.constant.message.ErrorMessage.NOT_ONLY_DIGIT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static final String DELIMITER = ",";

    public static int convertInteger(String input) {
        validateOnlyDigit(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> convertIntegerList(String input) {
        return Arrays.stream(input.split(DELIMITER, -1))
                .peek(Converter::validateOnlyDigit)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void validateOnlyDigit(String input) {
        if (!input.chars().allMatch(Character::isDigit) || input.isEmpty()) {
            throw new NumberFormatException(NOT_ONLY_DIGIT.getMessage());
        }
    }
}
