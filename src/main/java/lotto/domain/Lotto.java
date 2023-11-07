package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.List;

import static lotto.exception.ErrorMessage.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumberDuplication(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateNumberDuplication(List<Integer> numbers) {
        long distinctNumber = numbers.stream()
                .distinct()
                .count();

        if (distinctNumber < numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (isWrongRangeNumber(numbers)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private boolean isWrongRangeNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < LottoConstant.MIN_NUMBER
                        || number > LottoConstant.MAX_NUMBER);
    }

    public String getSortedNumbers() {
        return numbers.stream()
                .sorted()
                .map(number -> number.toString())
                .toList()
                .toString();
    }

    public boolean isContainNumber(int number) {
        return numbers.contains(number);
    }
}
