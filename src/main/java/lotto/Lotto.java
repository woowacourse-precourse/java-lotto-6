package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contain(int number){
        return this.numbers.contains(number);
    }

    public int returnNumber(int index){
        return this.numbers.get(index);
    }

    private void checkDuplicateNumber(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>(numbers);
        if(numbers.size()!=numberSet.size()){
            throw new IllegalArgumentException();
        }
    }
}
