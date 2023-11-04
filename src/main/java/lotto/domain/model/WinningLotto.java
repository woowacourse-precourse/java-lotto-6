package lotto.domain.model;

import lotto.constant.IllegalArgumentExceptionType;

public final class WinningLotto {
    private final Lotto lotto;
    private final LottoBonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoBonusNumber bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoBonusNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(Lotto lotto, LottoBonusNumber bonusNumber) {
        if (lotto.contains(bonusNumber.getValue())) {
            throw IllegalArgumentExceptionType.WINNING_LOTTO_CONTAINS_BONUS_NUMBER.getException();
        }
    }

    public boolean contains(int number) {
        return lotto.contains(number);
    }
}
