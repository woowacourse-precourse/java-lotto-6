package lotto.domain;

import lotto.utils.LottoValidator;
import lotto.utils.MessageConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortAscendingOrder(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSizeOfNumbers(numbers);
        validateDuplication(numbers);
        LottoValidator.validateOutOfRange(numbers);
    }

    private void validateSizeOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(MessageConstant.LOTTO_SIZE);
        }
    }

    public void validateDuplication(List<Integer> numbers) {
        if (hasDuplication(numbers)) {
            throw new IllegalArgumentException(MessageConstant.DUPLICATION);
        }
    }

    private boolean hasDuplication(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    private List<Integer> sortAscendingOrder(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public int countWinningNumber(Lotto o) {
        return (int) this.numbers.stream()
                .filter(o.numbers::contains)
                .count();
    }

    public boolean hasBonusNumber(int bonus) {
        return numbers.contains(bonus);
    }

    @Override
    public String toString() {
        return "[" +
                numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "))
                + "]";
    }
}
