package lotto.domain;

import lotto.constant.ErrorMessages;
import lotto.constant.NumberConstants;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.NumberConstants.*;

public class Lotto {
    private final List<Integer> numbers;
    private int matchNumberCount = 0;
    private boolean matchBonusCount;
    private int prize;

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public void setMatchNumberCount(int matchNumberCount) {
        this.matchNumberCount = matchNumberCount;
    }

    public boolean isMatchBonusCount() {
        return matchBonusCount;
    }

    public void setMatchBonusCount(boolean matchBonusCount) {
        this.matchBonusCount = matchBonusCount;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicateNumber(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != WINNING_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.DUPLICATE_NUMBER.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        long count = numbers.stream()
                .filter(num -> num > NUMBER_RANGE_MIN && num < NUMBER_RANGE_MAX)
                .count();

        if (count != WINNING_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.DUPLICATE_NUMBER.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
