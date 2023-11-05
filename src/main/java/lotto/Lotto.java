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
        if(!validateDuplicatedNumber(numbers)){
            throw new IllegalArgumentException();
        }
        if(!validateOverRangeNumber(numbers)){
            throw new IllegalArgumentException();
        }
    }

    private boolean validateDuplicatedNumber(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>(numbers);
        return numbers.size() == numberSet.size();
    }

    private boolean validateOverRangeNumber(List<Integer> numbers){
        for(int number : numbers){
            if(number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER){
                return false;
            }
        }
        return true;
    }

}
