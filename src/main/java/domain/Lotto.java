package domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isLottoContainDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void isLottoContainDuplicateNumber(List<Integer> numbers) {
        List<Integer> check = numbers.stream().distinct().toList();
        if(check.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
