package lotto.domain;

import lotto.exception.DuplicateNumberException;
import lotto.exception.InvalidNumbersSizeException;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isLengthLottoNumber(numbers);
        isDuplicateLottoNumber(numbers);
    }

    private void isLengthLottoNumber(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_MAX_LENGTH) {
            throw new InvalidNumbersSizeException();
        }
    }

    private void isDuplicateLottoNumber(List<Integer> number) {
        boolean hasDuplicates = number.size() != new HashSet<>(number).size();

        if (hasDuplicates) {
            throw new DuplicateNumberException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}