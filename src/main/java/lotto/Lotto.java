package lotto;

import java.util.List;
import java.util.Set;
import lotto.common.Constraint;
import lotto.common.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers){
        validateOverSize(numbers);
        validateDuplicated(numbers);
        validateOutOfRange(numbers);
        this.numbers = numbers;
    }

    private void validateOverSize(List<Integer> numbers) {
        if (numbers.size() != Constraint.LOTTO_MAX_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OVER_SIZE.getMessage());
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATED.getMessage());
        }
    }

    private void validateOutOfRange(List<Integer> numbers) {
        for (Integer i : numbers) {
            if (i < Constraint.LOTTO_MIN_NUMBER.getValue() || i > Constraint.LOTTO_MAX_NUMBER.getValue()) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

}
