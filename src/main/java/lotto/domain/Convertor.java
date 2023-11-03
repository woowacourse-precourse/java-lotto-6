package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convertor {
    private static final String DELIMITER = ",";

    public List<Number> convertToNumbers(String input) {
        List<Number> numbers = Arrays.stream(separate(input))
                .map(number -> new Number(number.trim()))
                .collect(Collectors.toList());
        return numbers;
    }

    private String[] separate(String input) {
        String[] inputNumbers = input.split(DELIMITER);
        return inputNumbers;
    }

}
