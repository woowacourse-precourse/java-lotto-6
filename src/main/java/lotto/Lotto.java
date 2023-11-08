package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    static final int NUMBER_OF_NUMBERS = 6;
    
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
    
    int matchedCount(List<Integer> numbers) {
        List<Integer> copyOfNumbers = new ArrayList<Integer>(numbers);
        copyOfNumbers.retainAll(this.numbers);
        return copyOfNumbers.size();
    }
    
    boolean isContain(int number) {
        return this.numbers.contains(number);
    }
}
