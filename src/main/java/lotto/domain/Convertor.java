package lotto.domain;

import static java.util.Arrays.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Convertor {
    private static final String DELIMITER = ",";

    public static List<Integer> convertToNumbers(String input) {
        return stream(separate(input))
                .map(number -> new Number(number.trim()))
                .map(Number::getNumber)
                .collect(Collectors.toList());
    }

    private static String[] separate(String input) {
        return input.split(DELIMITER);
    }
}
