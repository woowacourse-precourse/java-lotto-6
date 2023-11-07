package lotto;

import java.util.List;

public class Lotto {
    private static final String WRONG_LEGNTH_LOTTO_NUMBER_MESSAGE = "[ERROR] 로또 번호는 6개의 숫자여야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isSameLength(numbers)) {
            throw new IllegalArgumentException(WRONG_LEGNTH_LOTTO_NUMBER_MESSAGE);
        }
    }

    private boolean isSameLength(List<Integer> numbers) {
        return numbers.size() == 6;
    }
}
