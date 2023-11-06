package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getNumber(int index) {
        return numbers.get(index);
    }

    public int getSize(){
        return numbers.size();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

}
