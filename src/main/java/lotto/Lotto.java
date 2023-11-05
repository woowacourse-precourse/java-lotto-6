package lotto;

import lotto.utils.ErrorMessage;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
        numbers.forEach(this::validateSize);
        validateDuplicatedNumber(numbers);
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public void checkDuplicatedNumber(int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }


    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private void validateSize(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
