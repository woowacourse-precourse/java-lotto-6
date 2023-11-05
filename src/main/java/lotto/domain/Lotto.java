package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers.stream().toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
