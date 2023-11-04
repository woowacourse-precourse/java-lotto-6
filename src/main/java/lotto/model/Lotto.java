package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || hasDuplicates(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 중복되지 않은 6개의 숫자로 이루어져야 합니다.");
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() < numbers.size();
    }

    // TODO: 추가 기능 구현
}
