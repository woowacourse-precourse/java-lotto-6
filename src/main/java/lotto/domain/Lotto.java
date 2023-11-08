package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.Constant;
import lotto.constant.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Integer::compareTo);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumberRange(numbers);
        validateDuplicate(numbers);
    }

    public void validateNumberSize(final List<Integer> numbers) {
        if (numbers.size() != Constant.NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_SIZE.getMessage());
        }
    }

    public void validateNumberRange(final List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Constant.MIN_NUMBER || number > Constant.MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
            }
        }
    }

    public void validateDuplicate(final List<Integer> numbers) {
        boolean[] checkDuplicateNumber = new boolean[Constant.AVAILABLE_NUMBERS];
        for (int number : numbers) {
            if (checkDuplicateNumber[number]) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE.getMessage());
            }
            checkDuplicateNumber[number] = true;
        }
    }

    public int countOfMatch(final Lotto lotto) {
        int count = 0;
        for (int number : lotto.numbers) {
            if (this.numbers.contains(number)) {
                ++count;
            }
        }
        return count;
    }

    public boolean contains(final int number) {
        return this.numbers.contains((number));
    }

    @Override
    public String toString() {
        StringBuilder stringLotto = new StringBuilder();
        stringLotto.append('[');
        for (int number : numbers) {
            stringLotto.append(number);
            stringLotto.append(", ");
        }
        stringLotto.delete(stringLotto.length() - 2, stringLotto.length());
        stringLotto.append(']');
        return stringLotto.toString();
    }
}
