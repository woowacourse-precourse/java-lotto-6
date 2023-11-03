package lotto.domain;

import java.util.List;

public class Lotto {

    private final static Integer MIN_NUMBER = 1;

    private final static Integer MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        numbers.forEach(this::validateNumber);
    }

    private void validateNumber(final Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public long calculateSameCount(final WinnerNumbers winnerNumbers) {
        return numbers.stream().filter(winnerNumbers::containNumber).count();
    }

    public long calculateSameBonusCount(final WinnerNumbers winnerNumbers) {
        return numbers.stream().filter(winnerNumbers::containBonusNumber).count();
    }
}
