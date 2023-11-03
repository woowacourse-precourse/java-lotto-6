package lotto.model;

import lotto.constant.Constant;
import lotto.message.ExceptionMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        consistOfLottoSize(numbers);
        isInRange(numbers);
        isNotDuplicated(numbers);
    }

    private void consistOfLottoSize(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_SIZE.getValue()) {
            ExceptionMessage.NOT_SAME_WITH_LOTTO_SIZE.throwException(Constant.LOTTO_SIZE.getValue());
        }
    }

    private void isInRange(List<Integer> numbers) {
        int minLottoNumber = Constant.MIN_LOTTO_NUMBER.getValue();
        int maxLottoNumber = Constant.MAX_LOTTO_NUMBER.getValue();
        boolean isInRangeValue = numbers.stream().allMatch(number -> number >= minLottoNumber && number <= maxLottoNumber);
        if (!isInRangeValue) {
            ExceptionMessage.IS_NOT_IN_RANGE.throwException(minLottoNumber, maxLottoNumber);
        }
    }

    private void isNotDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            ExceptionMessage.CONSIST_OF_DUPLICATE_NUMBER.throwException();
        }
    }
}
