package lotto;

import java.util.List;

public class Lotto {
    private static final String VALIDATE_COUNT_MASSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(VALIDATE_COUNT_MASSAGE);
        }
    }

    // TODO: 추가 기능 구현
}
