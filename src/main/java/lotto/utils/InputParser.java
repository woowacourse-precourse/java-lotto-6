package lotto.utils;

import lotto.constants.ErrorConsts;

import java.util.List;
import java.util.stream.Stream;

public class InputParser {

    public static int parseToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(ErrorConsts.INPUT_VALUE_NOT_INTEGER.getMessage(), e);
        }
    }

    public static List<Integer> parseToIntegerListByDelimiter(final String input, final String delimiter) {
        return Stream.of(input.split(delimiter))
                .map(InputParser::parseToInt)
                .toList();
    }
}
