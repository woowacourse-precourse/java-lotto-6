package lotto.domain;

import java.util.List;


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
    }

    public int getSixNumberWinningResult(List<Integer> consumerSixNumber) {
        return numbers.stream()
                .filter(consumerSixNumber::contains)
                .toList()
                .size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
