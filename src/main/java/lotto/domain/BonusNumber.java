package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoRule;
import lotto.constant.WinningGrade;

public final class BonusNumber {

    private final Integer value;

    public BonusNumber(final Integer value) {
        validate(value);
        this.value = value;
    }

    private void validate(final Integer value) {
        if (LottoRule.MIN_NUMBER.toValue() > value || LottoRule.MAX_NUMBER.toValue() < value) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.toValue());
        }
    }

    public WinningGrade checkSecondWinning(final Lotto lotto) {
        if (hasBonusNumber(lotto)) {
            return WinningGrade.SECOND_GRADE;
        }
        return WinningGrade.THIRD_GRADE;
    }

    private boolean hasBonusNumber(final Lotto lotto) {
        return lotto.contains(value);
    }

    public Integer toValue() {
        return this.value;
    }
}
