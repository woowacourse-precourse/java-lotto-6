package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
        this.numbers = sortAscend(new ArrayList<>(numbers));
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_NUMBER_COUNT);
        }
    }

    // TODO: 추가 기능 구현

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int hasWinningNumber(Lotto winningLotto) {
        return (int) this.numbers.stream().filter(winningLotto.numbers::contains).count();
    }

    private void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> duplicatedNumbers = new HashSet<>(numbers);
        if (duplicatedNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_DUPLICATE_LOTTO_NUMBER);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(number -> 1 <= number && number <= 45)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_NUMBER_RANGE);
        }
    }

    private List<Integer> sortAscend(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
