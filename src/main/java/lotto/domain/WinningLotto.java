package lotto.domain;

import lotto.exception.ErrorStatus;
import lotto.exception.LottoArgumentException;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusBall bonusNumber;

    public WinningLotto(Lotto lotto, BonusBall bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }

    public int matchCount(Lotto lotto) {
        return lotto.matchCount(this.lotto);
    }

    public boolean isMatchBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber.getBonusNumber());
    }

    private void validate(Lotto lotto, BonusBall bonusNumber) {
        validateDuplicate(lotto, bonusNumber);
    }

    private void validateDuplicate(Lotto lotto, BonusBall bonusNumber) {
        if (lotto.contains(bonusNumber.getBonusNumber())) {
            throw new LottoArgumentException(ErrorStatus.BONUS_NUMBER_DUPLICATE_ERROR);
        }
    }

}
