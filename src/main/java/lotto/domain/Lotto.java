package lotto.domain;

import lotto.message.Error;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.LOTTO_MORE_THAN_SIX_NUMBER.getMessage());
        }

        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_DUPLICATE.getMessage());
        }

        for (int number : numbers) {
            validateLottoRange(number);
        }
    }

    protected void validateLottoRange(int number) {
        if (isNotValidRange(number)) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    protected boolean isNotValidRange(int number) {
        return number < 1 || number > 45;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append("[")
                .append(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            sb.append(", ").append(numbers.get(i));
        }
        sb.append("]");
        return sb.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
