package lotto.model;

import lotto.model.enums.LottoSpec;
import lotto.view.enums.ErrorMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    protected void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateNumberInRange(numbers);
        validateDuplicate(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    protected void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalStateException(ErrorMessage.LOTTO_NUMBERS_WRONG_SIZE.getMessage());
        }
    }

    protected void validateNumberInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoSpec.MIN_NUMBER.getValue() || number > LottoSpec.MAX_NUMBER.getValue()) {
                throw new IllegalStateException(ErrorMessage.WINNING_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    protected void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != 6) {
            throw new IllegalStateException(ErrorMessage.LOTTO_NUMBER_DUPLICATED.getMessage());
        }
    }

}
