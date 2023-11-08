package lotto.domain;

import lotto.Lotto;
import lotto.constant.ExceptionMessage;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validateDuplicate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.isContain(bonusNumber.getValue())) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
    public boolean isContain(int number) {
        return lotto.isContain(number);
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
