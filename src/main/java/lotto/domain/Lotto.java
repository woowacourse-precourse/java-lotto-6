package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public LottoMatchResult compare(List<Integer> winningNumbers, int bonusNumber) {
        return new LottoMatchResult(
                getMatchCount(winningNumbers),
                isMatchBonus(bonusNumber)
        );
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> !isOnRange(number))) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOnRange(int number) {
        return LOTTO_NUMBER_MIN <= number && number <= LOTTO_NUMBER_MAX;
    }

    private int getMatchCount(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    private boolean isMatchBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
