package lotto;

import java.util.List;

public class Lotto {
    private static final int LOTTO_LENGTH = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLengthCheck(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateLengthCheck(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(String.format("로또 번호의 갯수 %d개를 만족해야합니다.", LOTTO_LENGTH));
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        if (getDistinctCount(numbers) != LOTTO_LENGTH) {
            throw new IllegalArgumentException("숫자는 중복될 수 없습니다.");
        }
    }

    private int getDistinctCount(List<Integer> numbers) {
        return (int) numbers.stream()
                .distinct()
                .count();
    }
}
