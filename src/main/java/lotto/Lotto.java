package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        validateOverRangeNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
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
            if(number > 45 || number < 1){
                throw new IllegalArgumentException();
            }
        }
    }
}
