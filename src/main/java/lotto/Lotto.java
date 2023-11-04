package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    static final int MAX_LOTTO_NUMBER = 45;
    static final int MIN_LOTTO_NUMBER = 1;
    static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        validateOverRangeNumber(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>();
        numberSet.addAll(numbers);
        if(numbers.size() != numberSet.size()){
            throw new IllegalArgumentException();
        }
    }

    private void validateOverRangeNumber(List<Integer> numbers){
        for(int number : numbers){
            if(number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER){
                throw new IllegalArgumentException();
            }
        }
    }

}
