package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoNumbersDuplication(numbers);
        validateLottoNumberRange(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void validateLottoNumbersDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        numbers.forEach(item -> {
            if (item < 1 || item > 45) {
                throw new IllegalArgumentException();
            }
        });
    }


    @Override
    public String toString() {
        return numbers.toString();
    }
}
