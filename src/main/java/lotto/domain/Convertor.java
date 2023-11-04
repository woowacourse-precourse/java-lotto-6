package lotto.domain;

import static java.util.Arrays.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Convertor {
    private static final String DELIMITER = ",";

    public List<Integer> convertToIntegers(String input) {
        List<Integer> numbers = convertToNumbers(input).stream()
                .map(Number::getNumber)
                .sorted()
                .collect(Collectors.toList());
        return numbers;
    }

    private List<Number> convertToNumbers(String input) {
        List<Number> numbers = stream(separate(input))
                .map(number -> new Number(number.trim()))
                .collect(Collectors.toList());
        return numbers;
    }

    private String[] separate(String input) {
        return input.split(DELIMITER);
    }
}
