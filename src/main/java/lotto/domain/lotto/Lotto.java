package lotto.domain.lotto;

import java.util.List;
import java.util.Set;
import lotto.exception.DuplicateException;
import lotto.exception.NotLottoNumberException;
import lotto.exception.NotLottoSizeException;

public class Lotto {
    public static final int SIZE = 6;
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateLottoNumbers(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new NotLottoSizeException();
        }
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        numbers.forEach(this::validateLottoNumber);
    }

    private void validateLottoNumber(int number) {
        if (!(MIN_NUM <= number && number <= MAX_NUM)) {
            throw new NotLottoNumberException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = Set.copyOf(numbers);
        if (set.size() != SIZE) {
            throw new DuplicateException();
        }
    }

    public int match(Lotto other) {
        return (int) other.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean hasBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public String print() {
        return numbers.toString();
    }
}
