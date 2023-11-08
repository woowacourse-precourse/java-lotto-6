package lotto.domain;

import java.util.Set;
import lotto.global.ErrorMessage;

public class WinningNumbers {
    private int bonusNumber;
    private Set<Integer> originalWinningNumbers;

    public WinningNumbers(Set<Integer> originalWinningNumbers, int bonusNumber) {
        validate(originalWinningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
        this.originalWinningNumbers = originalWinningNumbers;
    }

    void validate(Set<Integer> originalWinningNumbers, int bonusNumber) {
        if (originalWinningNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_LOTTO_NUMBERS_LENGTH.getMessage());
        }
        for (Integer originalWinningNumber : originalWinningNumbers) {
            validateLottoRange(originalWinningNumber);
        }
        validateLottoRange(bonusNumber);
        if (originalWinningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_CONTAINS_BONUS_NUMBER_IN_WINNING_NUMBERS.getMessage());
        }
    }

    void validateLottoRange(int number) {
        if (!(1 <= number && number <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_LOTTO_NUMBERS_RANGE.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Set<Integer> getOriginalWinningNumbers() {
        return originalWinningNumbers;
    }
}
