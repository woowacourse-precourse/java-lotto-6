package lotto.domain.Model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호가 6개가 아닙니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
