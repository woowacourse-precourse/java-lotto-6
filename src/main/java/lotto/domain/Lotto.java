package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        numbers.forEach(number -> {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        });

        if( new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
