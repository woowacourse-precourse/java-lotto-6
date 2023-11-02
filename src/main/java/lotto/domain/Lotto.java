package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final Integer NUMBER_LENGTH = 6;
    public static final Integer MIN = 1;
    public static final Integer MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_LENGTH
                || numbers.stream().allMatch(value -> value >= MIN)
                || numbers.stream().allMatch(value -> value <= MAX)
                || hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 중복되지 않는 숫자여야 합니다.");
        }

    }

    private boolean hasDuplicateNumber(List<Integer> numbers) {
        List<Integer> distinctValues = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        return distinctValues.size() < numbers.size();
    }

    // TODO: 추가 기능 구현
}
