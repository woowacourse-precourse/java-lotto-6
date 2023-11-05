package lotto.domain;

import lotto.domain.wrapper.LottoNumber;
import lotto.utils.ErrorMessage;

public class LottoPrizeChecker {
    Lotto winningLotto;
    LottoNumber bonusNumber;

    public LottoPrizeChecker(Lotto winningLotto, LottoNumber bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.doesHaveLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_CONTAINS_BONUS_NUMBER.getWithPrefix());
        }
    }
}
