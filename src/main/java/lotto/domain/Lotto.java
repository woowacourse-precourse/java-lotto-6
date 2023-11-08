package lotto.domain;

import lotto.message.ErrorMessage;

import java.util.*;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return Collections.unmodifiableList(sortedNumbers);
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicate(numbers);
        checkValidRange(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE.getMessage());
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE.getMessage());
        }
    }

    private void checkValidRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE_LOW.getMessage());
            }
            if (number > MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE_HIGH.getMessage());
            }
        }
    }

    public int countMatches(Lotto winningLotto) {
        return (int) this.numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
    }

    public boolean matchesBonus(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
