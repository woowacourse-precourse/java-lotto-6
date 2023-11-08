package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.config.Constant;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(Constant.DUPLICATE_NUMBER_EXCEPTION);
        }

        for (int number : numbers) {
            if (number < Constant.MIN_LOTTO_NUMBER || number > Constant.MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(Constant.NUMBER_RANGE_EXCEPTION);
            }
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }
}
