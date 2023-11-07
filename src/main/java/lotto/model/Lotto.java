package lotto.model;

import static lotto.common.Constant.LOTTO_NUMBERS_SIZE;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto issue(List<Integer> numbers) {
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (hasOverSize(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasOverSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBERS_SIZE;
    }

    public int countMatchingNumbers(MainNumbers mainNumbers) {
        Set<Integer> drawnNumbers = mainNumbers.getMainNumbers()
                .stream()
                .map(MainNumber::getMainNumber)
                .collect(Collectors.toSet());

        return (int) numbers.stream()
                .filter(drawnNumbers::contains)
                .count();
    }

    public boolean hasBonusNumber(BonusNumber bonusNumber) {
        return numbers.stream()
                .anyMatch(number -> bonusNumber.getBonusNumber() == number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
