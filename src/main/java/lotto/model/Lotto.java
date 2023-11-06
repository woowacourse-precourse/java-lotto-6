package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (validateDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자를 가질 수 없습니다");
        }
    }
    private boolean validateDuplicateNumber(List<Integer> numbers) {
        return (numbers.stream().distinct().count() < numbers.size());
    }
}
