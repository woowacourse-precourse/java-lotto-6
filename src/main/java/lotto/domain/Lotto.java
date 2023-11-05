package lotto.domain;

import java.util.List;

public class Lotto {
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개를 입력해야 합니다.";
    private static final int LOTTO_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}