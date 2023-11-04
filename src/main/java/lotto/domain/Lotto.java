package lotto.domain;

import java.util.List;


public class Lotto {
    private final List<Integer> numbers;
    private static final int MIN = 1;
    private static final int MAX = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        } else if (!isWithinRangeNum(numbers)) {
            throw new IllegalArgumentException();
        } else if (!isNotDuplicateNum(numbers)) {
            throw new IllegalArgumentException("중복입니다");
        }


    }

    private boolean isNotDuplicateNum(List<Integer> numbers) {
        return numbers.stream().distinct().count() == numbers.size();
    }

    private boolean isWithinRangeNum(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> number >= MIN && number <= MAX);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
