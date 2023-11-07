package lotto;

import java.util.List;

public class Lotto {
    private final int NUMBER_LENGTH = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(CustomErrorMessage.WRONG_NUMBER_LENGTH);
        }
    }

    // TODO: 추가 기능 구현
}
