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
