package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import lotto.constant.NumberConstant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validDuplicate(numbers);
        validNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NumberConstant.LOTTO_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    private void validDuplicate(List<Integer> numbers){
        Set<Integer> sNumbers = new HashSet<>(numbers);
        if (sNumbers.size() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    private void validNumberRange(List<Integer> numbers){
        for (int number : numbers){
            if (number < NumberConstant.MIN_NUMBER || number > NumberConstant.MAX_NUMBER){
                throw new IllegalArgumentException();
            }
        }
    }
}
