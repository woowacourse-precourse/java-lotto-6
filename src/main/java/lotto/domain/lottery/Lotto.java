package lotto.domain.lottery;

import lotto.domain.checker.NumberChecker;
import lotto.domain.prize.Prize;
import lotto.exception.LottoException;

import java.util.List;
import java.util.Objects;

import static lotto.domain.lottery.constants.LottoConstraint.LOTTO_PICK_COUNT;
import static lotto.exception.ErrorMessage.NUMBER_COUNT_INVALID;

public class Lotto extends NumberChecker {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumbersRange(numbers);
        validateDuplicatedList(numbers);

        this.numbers = numbers;
    }

    public int countPrizeNumberMatchingCount(Prize prize) {
        return (int) numbers.stream()
                .filter(prize::isPrizeNumber)
                .count();
    }

    public boolean isBonusNumberMatching(Prize prize) {
        return numbers.stream()
                .anyMatch(prize::isBonusNumber);
    }

    public boolean isAlreadyContainBonusNumber(final int number) {
        return numbers.contains(number);
    }

    private void validateNumberCount(final List<Integer> numbers) {
        if (isInvalidPickCount(numbers)) {
            throw LottoException.from(NUMBER_COUNT_INVALID);
        }
    }

    private boolean isInvalidPickCount(final List<Integer> numbers) {
        return !Objects.equals(numbers.size(), LOTTO_PICK_COUNT.getValue());
    }


    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
