package lotto.domain;

import lotto.exception.DuplicatedNumber;
import lotto.exception.NotRangeException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        containRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicate(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>();
        for(int n : numbers){
           if(numberSet.contains(n)){
               throw new DuplicatedNumber();
           }
            numberSet.add(n);
        }
    }

    private void containRange(List<Integer> numbers){
        for(int n : numbers){
            if(n < 1 || n > 45){
                throw new NotRangeException();
            }
        }
    }
}
