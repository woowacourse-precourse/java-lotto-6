package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (!numbers.stream()
                .allMatch(number -> number >= 1 && number <= 45)) {
            throw new IllegalArgumentException();
        }
        // TODO: 로또 번호 검증 추가 구현
    }

    // TODO: 추가 기능 구현
}
