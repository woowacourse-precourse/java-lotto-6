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
            throw new IllegalArgumentException("6개의 숫자를 입력해 주세요");
        } else if (!isWithinRangeNum(numbers)) {
            throw new IllegalArgumentException("1부터 45까지의 숫자만 입력해 주세요");
        } else if (!isNotDuplicateNum(numbers)) {
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력해 주세요.");
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
