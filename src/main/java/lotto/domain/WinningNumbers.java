package lotto.domain;

import static lotto.constant.ExceptionMessage.NO_DUPLICATE_ERROR_MESSAGE;
import static lotto.constant.ExceptionMessage.NO_DUPLICATE_WINNING_NUMBER_ERROR_MESSAGE;
import static lotto.constant.ExceptionMessage.OUT_OF_RANGE_ERROR_MESSAGE;

import java.util.HashSet;
import java.util.List;

public class WinningNumbers {

    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningNumbers(List<Integer> winningNumber, int bonusNumber) {
        validateOutOfRange(winningNumber);
        validateOutOfRange(bonusNumber);
        validateDuplicateWinningNumber(winningNumber);
        validateDuplicateBonusNumber(winningNumber, bonusNumber);
        this.winningNumber = new WinningNumber(winningNumber);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public LottoResults calculateLottoResult(Lotto lotto) {
        int correctCount = winningNumber.calculateCorrectNumberCount(lotto);
        boolean hasBonus = bonusNumber.hasBonus(lotto);
        return LottoResults.getLottoResult(correctCount, hasBonus);
    }

    private void validateDuplicateBonusNumber(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(NO_DUPLICATE_WINNING_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateDuplicateWinningNumber(List<Integer> winningNumber) {
        if (isDuplicateNumbers(winningNumber)) {
            throw new IllegalArgumentException(NO_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateOutOfRange(List<Integer> winningNumber) {
        for (int number : winningNumber) {
            if (isOutOfRange(number)) {
                throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private void validateOutOfRange(int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    private boolean isDuplicateNumbers(List<Integer> winningNumber) {
        return new HashSet<>(winningNumber).size() < 6;
    }

    private boolean isOutOfRange(int number) {
        return 45 < number || number < 1;
    }
}
