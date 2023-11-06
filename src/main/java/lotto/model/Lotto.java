package lotto.model;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || duplicate(numbers) != 6) {
            throw new IllegalArgumentException();
        }
    }
    private int duplicate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : numbers) set.add(num);
        return set.size();
    }
    public List<Integer> getLotto() {
        return numbers;
    }
}
