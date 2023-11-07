package lotto.domain;

import lotto.configuration.Constants;

import java.util.*;

import static lotto.configuration.LottoConfig.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }


    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != COUNT.getValue()) {
            throw new IllegalArgumentException(Constants.Error.MESSAGE + Constants.Error.LOTTO_IS + COUNT.getValue() + Constants.Error.HAS_DIGIT);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != COUNT.getValue()) {
            throw new IllegalArgumentException(Constants.Error.MESSAGE
                    + Constants.Error.MUST_NOT_DUPLICATE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < START.getValue() || number > END.getValue()) {
                throw new IllegalArgumentException(Constants.Error.MESSAGE
                        + Constants.Error.LOTTO_IS
                        + START.getValue() + Constants.Error.FROM + END.getValue()
                        + Constants.Error.MUST_CHECK_RANGE);
            }
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString() + "\n";
    }
}


