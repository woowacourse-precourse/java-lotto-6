package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> setNumbers = new HashSet<>(numbers);
        if(setNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void showLotto() {
        System.out.println(numbers.toString());
    }
}
