package lotto.model;

import static lotto.errorMessage.ExceptionErrorMessage.LOTTO_DUPLICATE;
import static lotto.errorMessage.ExceptionErrorMessage.LOTTO_RANGE;
import static lotto.errorMessage.ExceptionErrorMessage.LOTTO_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Lotto {
    private int MIN_LOTTO_NUMBER = 1;
    private int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(LOTTO_RANGE);
            }
        }
    }

    public int countMatch(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::containLottoNumber)
                .count();
    }

    public boolean containLottoNumber(int number) {
        return numbers.contains(number);
    }
}
