package lotto.domain;

import static lotto.exception.ExceptionMessage.LottoException.BONUS_NUMBER_MUST_BE_UNIQUE;

public class WinningLottoHolder {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private WinningLottoHolder(final Lotto winningLotto, final BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoHolder drawWinningLotto(final Lotto winningLotto, final BonusNumber bonusNumber) {
        validateBonusNumberIsDuplicate(winningLotto, bonusNumber);
        return new WinningLottoHolder(winningLotto, bonusNumber);
    }

    private static void validateBonusNumberIsDuplicate(final Lotto winningLotto, final BonusNumber bonusNumber) {
        if (winningLotto.isNumberInclude(bonusNumber.getValue())) {
            throw new IllegalArgumentException(BONUS_NUMBER_MUST_BE_UNIQUE.message);
        }
    }

    public int calculateLottoMatchCount(final Lotto userLotto) {
        return winningLotto.calculateMatchCount(userLotto);
    }

    public boolean isBonusNumberInclude(final Lotto userLotto) {
        return userLotto.isNumberInclude(bonusNumber.getValue());
    }
}
