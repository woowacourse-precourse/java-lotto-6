package lotto.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.RuleConstant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validDuplicate(numbers);
        validNumberRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != RuleConstant.LOTTO_RANGE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void validDuplicate(List<Integer> numbers) {
        Set<Integer> sNumbers = new HashSet<>(numbers);
        if (sNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < RuleConstant.MIN_NUMBER.getValue() || number > RuleConstant.MAX_NUMBER.getValue()) {
                throw new IllegalArgumentException();
            }
        }
    }
}
