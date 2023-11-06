package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.wrapper.LottoNumber;
import lotto.utils.ErrorMessage;
import lotto.utils.Prize;

public class PrizeChecker {
    Lotto winningLotto;
    LottoNumber bonusNumber;

    public PrizeChecker(Lotto winningLotto, LottoNumber bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.doesHaveLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_CONTAINS_BONUS_NUMBER.getWithPrefix());
        }
    }

    public Prize getPrize(Lotto playerLotto) {
        int sameCount = playerLotto.getSameCount(winningLotto);
        boolean hasBonusNumber = playerLotto.doesHaveLottoNumber(bonusNumber);
        return Prize.getPrizeRank(sameCount, hasBonusNumber);
    }
}
