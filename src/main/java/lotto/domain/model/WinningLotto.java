package lotto.domain.model;

import lotto.exception.lottonumbersexception.NumbersErrorMessage;

public class WinningLotto extends Lotto {
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        super(lotto.getNumbers());
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(BonusNumber bonusNumber) {
        if (getNumbers().contains(bonusNumber.getNumber())) {
            throw NumbersErrorMessage.DUPLICATE_BONUS_NUMBER.getException();
        }
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
