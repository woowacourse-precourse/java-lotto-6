package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.Constant;
import lotto.exception.ErrorMessage;

public class Lotto {

    private final List<Number> numbers; // private 변경 및 필드 추가 불가능

    private Lotto(List<Number> numbers) {
        validateNumbersLength(numbers);
        validateNumbersDuplicate(numbers);
        this.numbers = numbers;
    }

    public static Lotto create(String inputNumber) {
        List<Number> numbers = convertStringToNumbers(inputNumber);
        return new Lotto(numbers);
    }

    private static List<Number> convertStringToNumbers(String inputNumber) {
        List<Integer> inputNumbers = convertStringToList(inputNumber);
        return inputNumbers.stream()
                .map(Number::of)
                .collect(Collectors.toList());
    }

    private static List<Integer> convertStringToList(String inputNumber) {
        return Arrays.stream(inputNumber.split(Constant.COMMA.getCharValue()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void isEmpty(String inputNumber) {
        if (inputNumber.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUMBERS_NULL.get());
        }
    }

    private static void isContainsBlank(String inputNumber) {
        if (inputNumber.contains(Constant.BLANK.getCharValue())) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUMBERS_CONTAINS_BLANK.get());
        }
    }

    private static void isEndsWithComma(String inputNumber) {
        if (inputNumber.endsWith(Constant.COMMA.getCharValue())) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUMBERS_ENDS_WITH_COMMA.get());
        }
    }

    private void validateNumbersLength(List<Number> numbers) {
        if (numbers.size() != Constant.LOTTO_NUMBERS_MAX_LENGTH.getIntValue()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUMBERS_LENGTH.get());
        }
    }

    private void validateNumbersDuplicate(List<Number> numbers) {
        if (numbers.stream()
                .map(Number::getNumber)
                .distinct()
                .count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUMBERS_DUPLICATE.get());
        }
    }

}
