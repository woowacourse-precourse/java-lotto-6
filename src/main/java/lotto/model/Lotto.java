package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final String DUPLICATE_NUMBERS_ERROR_MESSAGE = "[ERROR] 로또 번호에 중복된 숫자가 포함되어 있습니다.";
    private static final String OUT_OF_RANGE_NUMBERS_ERROR_MESSAGE = "[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.";
    private static final String EXCESS_NUMBERS_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";


    public Lotto(List<Integer> numbers) {

        this.numbers = validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersForDuplicates(numbers);
        validateNumbersForRange(numbers);
        validateNumbersCount(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }



    private void validateNumbersForDuplicates(List<Integer> winningNumber) {
        List<Integer> uniqueNumbers = winningNumber.stream().distinct().toList();
        if (winningNumber.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS_ERROR_MESSAGE);
        }
    }

    private void validateNumbersForRange(List<Integer> winningNumber) {
        if (winningNumber.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBERS_ERROR_MESSAGE);
        }
    }

    private void validateNumbersCount(List<Integer> winningNumber) {
        if (winningNumber.size() > 6) {
            throw new IllegalArgumentException(EXCESS_NUMBERS_ERROR_MESSAGE);
        }
    }
}
