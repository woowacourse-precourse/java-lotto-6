package lotto.domain;

import lotto.data.Messages;

import java.util.List;
import java.util.function.Predicate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validDuplicate(numbers);
        validateLottoSize(numbers);
        validOutOfRange(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Messages.LOTTO_SIZE_ERROR_MESSAGE);
        }
    }

    private void validDuplicate(List<Integer> numbers) {
        boolean isDuplicate = numbers.stream()
                .distinct()
                .count() != numbers.size();

        if (isDuplicate) {
            throw new IllegalArgumentException(Messages.LOTTO_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validOutOfRange(List<Integer> numbers) {
        boolean outOfRange = numbers.stream()
                .anyMatch(num -> num < 1 || 45 < num);

        if (outOfRange) {
            throw new IllegalArgumentException(Messages.LOTTO_RANGE_ERROR_MESSAGE);
        }
    }

    public int matchNumbers(Lotto player) {
        List<Integer> playerNumbers = player.getNumbers();

        List<Integer> matchList = playerNumbers.stream().filter(o -> this.numbers.stream()
                .anyMatch(Predicate.isEqual(o))).toList();

        return matchList.size();
    }

    public boolean matchBonusNum(int bonusNum) {
        return numbers.contains(bonusNum);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
