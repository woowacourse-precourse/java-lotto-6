package lotto.domain;

import lotto.view.ErrorMessage;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    private WinningNumbers(Lotto winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validate(winningNumbers, bonusNumber);
    }

    public static WinningNumbers of(Lotto winningLotto, LottoNumber bonusNumber) {
        return new WinningNumbers(winningLotto, bonusNumber);
    }

    public int countMatchingNumber(Lotto lotto) {
        return winningNumbers.countMatchingNumber(lotto);
    }

    public boolean bonusNumberMatch(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    private void validate(Lotto winningLotto, LottoNumber bonusNumber) {
        validateBonusNumberHasNoConflict(winningLotto, bonusNumber);
    }

    private void validateBonusNumberHasNoConflict(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_CONFLICT.getErrorMessage());
        }
    }
}
