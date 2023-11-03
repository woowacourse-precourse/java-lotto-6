package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int STANDARD_SIZE = 6;
    public static final int MAX_VALUE = 45;
    public static final int MIN_VALUE = 1;
    private final List<Integer> numbers; // 필드 고정, private 도 고정

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        hasStandardSize(numbers);
        hasDuplicatedNumber(numbers);
        hasOutOfRangeNumber(numbers);
    }

    private void hasStandardSize(List<Integer> numbers) {
        if (numbers.size() != STANDARD_SIZE) {
            throw new IllegalArgumentException("6개의 숫자를 입력하지 않았습니다.");
        }
    }

    private void hasDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("중복된 숫자를 입력했습니다.");
        }
    }

    private void hasOutOfRangeNumber(List<Integer> numbers) {
        if (numbers.stream()
                .filter(number -> ((number > MAX_VALUE) || (number < MIN_VALUE)))
                .findFirst()
                .isPresent()) {
            throw new IllegalArgumentException("범위에서 벗어난 수를 입력했습니다. 로또 번호 범위는 1~45까지입니다");
        }
    }
}
