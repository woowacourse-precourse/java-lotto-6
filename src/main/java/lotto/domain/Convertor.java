package lotto.domain;

import static java.util.Arrays.stream;
import static lotto.constants.ExceptionMessage.IS_DUPLICATED;

import java.util.List;
import java.util.stream.Collectors;

public class Convertor {
    private static final String DELIMITER = ",";

    public List<Integer> convertToIntegers(String input) {
        List<Integer> numbers = convertToNumbers(input).stream()
                .map(Number::getNumber)
                .sorted()
                .collect(Collectors.toList());
        validateDuplicated(numbers);
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

    private void validateDuplicated(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(IS_DUPLICATED.getMessage());
        }
    }

    private boolean isDuplicated(List<Integer> number) {
        long result = number.stream()
                .distinct().count();
        return result != number.size();
    }
}
