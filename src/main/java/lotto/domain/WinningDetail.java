package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.WinningGrade;

public final class WinningDetail {

    private static final int MIN_INDEX = 0;
    private final WinningGrade winningGrade;
    private final Integer index;

    public WinningDetail(final WinningGrade winningGrade, final Integer index) {
        validate(index);
        this.winningGrade = winningGrade;
        this.index = index;
    }

    private void validate(final Integer index) {
        if (index < MIN_INDEX) {
            throw new IllegalStateException(ErrorMessage.INVALID_INDEX.toValue());
        }
    }

    public WinningGrade toWinningGrade() {
        return this.winningGrade;
    }

    public Integer toIndex() {
        return this.index;
    }

    public WinningDetail convertIfSecondWinning(final Lotto lotto, final BonusNumber bonusNumber) {
        if (winningGrade.isPossibleSecondWinner()) {
            return new WinningDetail(bonusNumber.checkSecondWinning(lotto), index);
        }
        return this;
    }
}
