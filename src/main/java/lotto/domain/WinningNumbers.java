package lotto.domain;

import java.util.HashSet;
import java.util.List;
import lotto.exception.LottoError;
import lotto.exception.LottoValidationException;

public class WinningNumbers {

    private static final int WINNING_NUMBER_COUNT = 6;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        validateNumberCount(winningNumbers);
        validateUniqueNumbers(winningNumbers);
        validateRange(winningNumbers);
        validateBonusNumber(winningNumbers, bonusNumber);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers == null || numbers.size() != WINNING_NUMBER_COUNT) {
            throw new LottoValidationException(LottoError.INVALID_WINNING_NUMBER_COUNT.toString());
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != WINNING_NUMBER_COUNT) {
            throw new LottoValidationException(LottoError.DUPLICATE_WINNING_NUMBER.toString());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new LottoValidationException(LottoError.NUMBER_OUT_OF_RANGE.toString());
        }
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new LottoValidationException(LottoError.BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER.toString());
        }
    }

    public int matchCount(Lotto lotto) {
        return lotto.countMatches(winningNumbers);
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
