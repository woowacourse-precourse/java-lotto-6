package lotto.domain;

import static lotto.view.constants.ConsoleMessage.DUPLICATE_NUMBER_ERROR;
import static lotto.view.constants.ConsoleMessage.WINNING_NUMBERS_ERROR;
import static lotto.view.constants.SeparatorConstant.WINNING_NUMBERS_SEPARATOR;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class WinningLotto {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int INCREASE_NUMBER = 1;

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    private WinningLotto(List<Integer> winningNumbers, Integer bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> winningNumbers, Integer bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public int countMatchingNumbers(Lotto lotto) {
        int result = countMatchingWinningNumbers(lotto);
        if (lotto.contains(bonusNumber)) {
            result += INCREASE_NUMBER;
        }
        return result;
    }

    public boolean containsBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    private int countMatchingWinningNumbers(Lotto lotto) {
        long count = winningNumbers.stream()
                .filter(lotto::contains)
                .count();

        return Long.valueOf(count).intValue();
    }

    private void validate(List<Integer> winningNumbers, Integer bonusNumber) {
        validateSize(winningNumbers);
        validateDuplicate(winningNumbers);
        validateInteger(winningNumbers);
        validateRange(winningNumbers);

        validateDuplicate(winningNumbers, bonusNumber);
        validateRange(bonusNumber);
    }

    private void validateDuplicate(List<Integer> winningNumbers, Integer bonusNumber) {
        if (hasDuplicate(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(
                    String.format(WINNING_NUMBERS_ERROR.getMessage(), WINNING_NUMBERS_SEPARATOR));
        }
    }

    private boolean hasDuplicate(List<Integer> winningNumbers, Integer bonusNumber) {
        return winningNumbers.stream()
                .anyMatch(Predicate.isEqual(bonusNumber));
    }

    private void validateInteger(List<Integer> winningNumbers) {
        if (hasNull(winningNumbers)) {
            throw new IllegalArgumentException(
                    String.format(WINNING_NUMBERS_ERROR.getMessage(), WINNING_NUMBERS_SEPARATOR));
        }
    }

    private boolean hasNull(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .anyMatch(Objects::isNull);
    }

    private void validateRange(List<Integer> winningNumbers) {
        boolean hasNotValidate = winningNumbers.stream()
                .anyMatch(this::notValidateRange);

        if (hasNotValidate) {
            throw new IllegalArgumentException(
                    String.format(WINNING_NUMBERS_ERROR.getMessage(), WINNING_NUMBERS_SEPARATOR));
        }
    }

    private void validateRange(Integer number) {
        if (notValidateRange(number)) {
            throw new IllegalArgumentException(
                    String.format(WINNING_NUMBERS_ERROR.getMessage(), WINNING_NUMBERS_SEPARATOR));
        }
    }

    private boolean notValidateRange(Integer number) {
        return number < MINIMUM_LOTTO_NUMBER || MAXIMUM_LOTTO_NUMBER < number;
    }

    private void validateDuplicate(List<Integer> winningNumbers) {
        if (hasDuplicate(winningNumbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

    private boolean hasDuplicate(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .distinct()
                .count() != LOTTO_NUMBERS_SIZE;
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(
                    String.format(WINNING_NUMBERS_ERROR.getMessage(), WINNING_NUMBERS_SEPARATOR));
        }
    }
}
