package lotto.domain;

import java.util.HashSet;
import java.util.List;
import lotto.exception.DuplicatedLottoException;
import lotto.exception.RangeLottoException;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplicated(numbers);
        validateRange(numbers);
    }

    private void validateDuplicated(List<Integer> numbers) {
        HashSet<Integer> lottoNumbers = new HashSet<>(numbers);

        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new DuplicatedLottoException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(this::validateRange);
    }

    private void validateRange(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new RangeLottoException();
        }
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
