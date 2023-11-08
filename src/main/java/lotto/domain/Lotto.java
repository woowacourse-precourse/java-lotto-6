package lotto.domain;

import lotto.exception.ErrorStatus;
import lotto.exception.LottoArgumentException;

import java.util.List;

public class Lotto {

    public static final int SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int PRICE = 1_000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortAsc(numbers);
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int matchCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private List<Integer> sortAsc(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Lotto.SIZE) {
            throw new LottoArgumentException(ErrorStatus.LOTTO_SIZE_ERROR);
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(this::validateRange);
    }

    private void validateRange(Integer number) {
        if (number < Lotto.MIN_NUMBER || number > Lotto.MAX_NUMBER) {
            throw new LottoArgumentException(ErrorStatus.LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != Lotto.SIZE) {
            throw new LottoArgumentException(ErrorStatus.LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }
}
