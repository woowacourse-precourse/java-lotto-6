package lotto.domain;

import static lotto.constant.ErrorMessage.*;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER.getMessage());
        }

        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER.getMessage());
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int countWin(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean checkBonus(Integer value) {
        return numbers.contains(value);
    }
}
