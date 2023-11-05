package lotto.model;

import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final String DUPLICATED_NUMBER_MESSAGE = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";
    private static final String INVALID_SIZE_MESSAGE = "[ERROR] 로또 번호는 6개의 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortAsc(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_MESSAGE);
        }

        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }
    }

    private List<Integer> sortAsc(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
