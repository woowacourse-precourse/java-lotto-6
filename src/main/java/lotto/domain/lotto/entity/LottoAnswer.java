package lotto.domain.lotto.entity;

import lotto.exception.LottoException;

public class LottoAnswer {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public LottoAnswer(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = new LottoNumber(bonusNumber);
        validate();
    }

    private void validate() {
        if (this.lotto.hasNumber(this.bonusNumber)) {
            throw LottoException.LOTTO_DUPLICATED_BONUS_NUMBER.makeException();
        }
    }

    public int getSameNumberCount(Lotto lotto) {
        return lotto.getSameNumberCount(this.lotto);
    }

    public boolean matchesBonusNumber(Lotto lotto) {
        return lotto.hasNumber(this.bonusNumber);
    }
}
