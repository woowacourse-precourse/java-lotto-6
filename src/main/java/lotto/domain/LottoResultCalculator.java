package lotto.domain;

import lotto.exception.ErrorMessage;

public class LottoResultCalculator {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    private LottoResultCalculator(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static LottoResultCalculator create(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return new LottoResultCalculator(winningNumbers, bonusNumber);
    }

    private void validateBonusNumber(BonusNumber bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }
}
