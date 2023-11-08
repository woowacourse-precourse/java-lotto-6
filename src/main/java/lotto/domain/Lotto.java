package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isSizeMatch(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자의 개수는 6개여야 합니다.");
        }
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또에 중복된 숫자가 존재합니다.");
        }
        if (!inRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 범위에 맞지 않는 수가 존재합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private boolean isSizeMatch(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_SIZE;
    }

    private boolean hasDuplicateNumber(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private boolean inRange(List<Integer> numbers) {
        return numbers
                .stream()
                .allMatch(number -> number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER);
    }
}
