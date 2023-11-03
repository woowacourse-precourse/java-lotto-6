package lotto.domain;

import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final String SIZE_EXCEPTION = "로또는 %d개의 번호로 이뤄져야 합니다.";
    private static final String DUPLICATE_EXCEPTION = "로또에 같은 번호가 존재합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(String.format(SIZE_EXCEPTION, LOTTO_NUMBERS_SIZE));
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();

        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
        }
    }
}
