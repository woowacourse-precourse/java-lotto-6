package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR]: 로또 숫자는 6개여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
