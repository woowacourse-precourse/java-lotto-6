package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;

import java.util.List;

public class Lotto {
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
        return numbers.size() == LottoConstant.LOTTO_NUMBER_SIZE;
    }

    private boolean isDuplicateNumber(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private boolean isInRange(List<Integer> numbers) {
        return numbers.stream().allMatch(
                number -> number >= LottoConstant.LOTTO_START_RANGE && number <= LottoConstant.LOTTO_END_RANGE);
    }
}
