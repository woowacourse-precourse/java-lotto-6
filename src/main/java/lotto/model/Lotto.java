package lotto.model;

import java.util.List;
import lotto.enums.Constant;
import lotto.enums.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);

        this.numbers = numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != Constant.COUNT_OF_LOTTO_NUMBERS.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OF_LOTTO_NUMBERS_IS_6.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != Constant.COUNT_OF_LOTTO_NUMBERS.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_HAS_NO_DUPLICATE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < Constant.START_RANGE_OF_NUMBER.getValue()
                    || Constant.END_RANGE_OF_NUMBER.getValue() < number) {
                throw new IllegalArgumentException(String.format(
                        ErrorMessage.LOTTO_NUMBERS_HAS_RANGE.getMessage(),
                        Constant.START_RANGE_OF_NUMBER.getValue(),
                        Constant.END_RANGE_OF_NUMBER.getValue()
                ));
            }
        }
    }

    public Integer countMatchesNumber(Lotto targetLotto) {
        Integer count = 0;

        for (Integer number : numbers) {
            if (targetLotto.isMatch(number)) {
                ++count;
            }
        }

        return count;
    }

    public Boolean isMatch(Integer number) {
        return numbers.contains(number);
    }
}
