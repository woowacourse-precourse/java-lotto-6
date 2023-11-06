package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_START_RANGE = 1;
    private static final int LOTTO_END_RANGE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isSizeSix(numbers)) {
            ErrorMessage.LOTTO_WRONG_NUMBER_SIZE.throwIllegalArgumentException();
        }
        if (isDuplicateNumber(numbers)) {
            ErrorMessage.LOTTO_NUMBER_IS_DUPLICATE.throwIllegalArgumentException();
        }
        if (!isInRange(numbers)) {
            ErrorMessage.LOTTO_NUMBER_IS_OUT_OF_RANGE.throwIllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private boolean isSizeSix(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_SIZE;
    }

    private boolean isDuplicateNumber(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private boolean isInRange(List<Integer> numbers) {
        return numbers.stream().allMatch(
                number -> number >= LOTTO_START_RANGE && number <= LOTTO_END_RANGE
        );
    }
}
