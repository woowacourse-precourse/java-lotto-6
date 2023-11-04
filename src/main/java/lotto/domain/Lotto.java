package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int matchCount = 0;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("");
        }
    }

    // TODO: 추가 기능 구현
    public void addMatchCount() {
        matchCount++;
    }
}
