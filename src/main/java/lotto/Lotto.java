package lotto;

import java.util.List;

public class Lotto {
    private static final String VALIDATE_COUNT_MASSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String VALIDATE_RANGE_MASSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(VALIDATE_COUNT_MASSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int a : numbers) {
            if (a < 1 || a > 45) {
                throw new IllegalArgumentException(VALIDATE_RANGE_MASSAGE);
            }
        }
    }

}
