package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_LENGTH_NOT_SIX.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getLotto() {
        return numbers;
    }
}
