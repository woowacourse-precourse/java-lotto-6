package lotto.model;

import lotto.constants.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.ExceptionMessage.LOTTO_NUMBERS_INVALID_ERROR;
import static lotto.constants.LottoSetting.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (hasInvalidSize(numbers) || hasInvalidRange(numbers) || hasDuplicates(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INVALID_ERROR.message());
        }
    }

    private boolean hasInvalidSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE.value();
    }

    private boolean hasInvalidRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(this::isOutOfRange);
    }

    private boolean isOutOfRange(int number) {
        return number < MIN_LOTTO_NUMBER.value() || number > MAX_LOTTO_NUMBER.value();
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
