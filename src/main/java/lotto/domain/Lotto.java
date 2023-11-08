package lotto.domain;

import java.util.List;
import lotto.Rank;
import lotto.exception.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateNotDuplicated(numbers);
        validateRange(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LottoRule.SIZE.value()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_SIZE.getMessage());
        }
    }

    private void validateNotDuplicated(final List<Integer> numbers) {
        if (duplicated(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBERS.getMessage());
        }
    }

    private boolean duplicated(final List<Integer> numbers) {
        long distinctSize = numbers.stream().
                distinct().
                count();
        return numbers.size() != distinctSize;
    }

    private void validateRange(final List<Integer> numbers) {
        if (outOfRange(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBERS_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean outOfRange(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(LottoRule::outOfRange);
    }

    public Rank rank(final Lotto winningLotto, final int bonus) {
        int matches = (int) numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
        boolean bonusMatched = numbers.contains(bonus);
        return Rank.from(matches, bonusMatched);
    }

    public boolean contains(final int number) {
        return numbers.contains(number);
    }
}
