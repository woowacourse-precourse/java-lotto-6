package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrizeLotto {
    private final List<Integer> numbers;

    public PrizeLotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        containRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    private void duplicate(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>();
        for(int n : numbers){
            if(numberSet.contains(n)){
                throw new IllegalArgumentException();
            }
            numberSet.add(n);
        }
    }

    private void containRange(List<Integer> numbers){
        for(int n : numbers){
            if(n < 1 || n > 45){
                throw new IllegalArgumentException();
            }
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 7) {
            throw new IllegalArgumentException();
        }
    }
}
