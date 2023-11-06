package lotto.domain;

import java.util.List;
import lotto.exception.DuplicateNumberException;
import lotto.exception.InvalidSizeException;
import lotto.exception.NumberOutOfRangeException;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatch(WinnerLotto winnerLotto) {
        return (int) this.numbers.stream()
                .filter(winnerLotto::matchesLottoNumber)
                .count();
    }

    public boolean countBonusMatch(WinnerLotto winnerLotto) {
        return numbers.stream()
                .anyMatch(winnerLotto::matchesBonusNumber);
    }

    private void validateLotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new InvalidSizeException();
        }
    }
    private void validateDuplicateNumber(List<Integer> numbers) {
        if (countDistinctNumber(numbers) != LOTTO_SIZE) {
            throw new DuplicateNumberException();
        }
    }
    private void validateRange(List<Integer> numbers) {
        // TODO: 한 줄에 모든 로직을 작성하지 않고, 분리해서 작성할까?
        if (numbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new NumberOutOfRangeException();
        }
    }
    private Long countDistinctNumber(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }
}
