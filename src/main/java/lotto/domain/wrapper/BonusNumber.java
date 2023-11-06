package lotto.domain.wrapper;

import lotto.domain.Lotto;
import lotto.utils.ErrorMessage;

public class BonusNumber extends LottoNumber {
    public BonusNumber(int bonusNumber, Lotto winningLotto) {
        super(bonusNumber);
        validateBonusLottoNumber(bonusNumber, winningLotto);
    }

    private void validateBonusLottoNumber(int bonusNumber, Lotto winningLotto) {
        if (winningLotto.doesHaveLottoNumber(new LottoNumber(bonusNumber))) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_CONTAINS_BONUS_NUMBER.getWithPrefix());
        }
    }
}
