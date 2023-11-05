package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicatedNumbers(List<Integer> numbers) {
        HashSet<Integer> lottoNumbersSet = new HashSet<>(numbers);
        if (lottoNumbersSet.size() < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복되면 안됩니다.");
        }
    }
}
