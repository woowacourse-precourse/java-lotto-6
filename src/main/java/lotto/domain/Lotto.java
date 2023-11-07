package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.validation.Error;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.LOTTO_COUNT_ERROR.getMessage());
        }

        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(Error.LOTTO_DUPLICATE_ERROR.getMessage());
        }
    }

    public void printLotto() {
        Collections.sort(numbers);
        System.out.println(numbers);
    }

    public int match(List<Integer> WinningNumbers) {
        return (int) WinningNumbers
                .stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean match(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
