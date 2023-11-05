package lotto.domain;

import lotto.exception.LottoException;
import lotto.exception.LottoExceptionMessage;

public record LottoDraw(Lotto winningLotto , int bonusNumber) {
    public LottoDraw(Lotto winningLotto , int bonusNumber){
        validateLottoContainBonusNumber(winningLotto,bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
    private static void validateLottoContainBonusNumber(Lotto winningLotto,int bonusNumber){
        if (winningLotto.getNumbers().contains(bonusNumber)){
            throw new LottoException(LottoExceptionMessage.DUPLICATE_BONUS_NUMBER);
        }
    }
}