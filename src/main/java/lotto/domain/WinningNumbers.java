package lotto.domain;

import static lotto.constant.ExceptionMessage.NO_DUPLICATE_WINNING_NUMBER_ERROR_MESSAGE;

public class WinningNumbers {

    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningNumbers(WinningNumber winningNumber, BonusNumber bonusNumber) {
        validateDuplicate(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public LottoResults calculateLottoResult(Lotto lotto) {
        int correctCount = winningNumber.calculateCorrectNumberCount(lotto);
        boolean hasBonus = bonusNumber.hasBonus(lotto);
        return LottoResults.getLottoResult(correctCount, hasBonus);
    }

    private void validateDuplicate(WinningNumber winningNumber, BonusNumber bonusNumber) {
        if (bonusNumber.hasBonus(winningNumber)) {
            throw new IllegalArgumentException(NO_DUPLICATE_WINNING_NUMBER_ERROR_MESSAGE);
        }
    }
}
