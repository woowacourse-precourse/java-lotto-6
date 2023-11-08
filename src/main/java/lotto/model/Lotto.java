package lotto.model;

import lotto.view.ErrorConstants;

import java.util.List;

public class Lotto {
    protected static final int MAX_LOTTO_NUMBER = 45;
    protected static final int MIN_LOTTO_NUMBER = 1;
    public static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorConstants.ILLEGAL_LOTTO_SIZE_ERROR);
        }
        if (isNumbersNotInEffectiveRange(numbers)) {
            throw new IllegalArgumentException(ErrorConstants.ILLEGAL_LOTTO_NUMBER_ERROR);
        }
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException(ErrorConstants.LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }

    private boolean isNumbersNotInEffectiveRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER);
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        int sizeOfDistinctNumbers = (int) numbers.stream().distinct().count();
        return sizeOfDistinctNumbers != LOTTO_NUMBERS_SIZE;
    }

    public boolean contain(Integer number) {
        return numbers.contains(number);
    }

    public int getLottoNumber(int position) {
        return numbers.get(position);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
