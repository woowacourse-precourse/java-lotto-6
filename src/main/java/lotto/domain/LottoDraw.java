package lotto.domain;

import lotto.domain.constant.LottoConstant;
import lotto.exception.LottoException;
import lotto.exception.LottoExceptionMessage;

public record LottoDraw(Lotto winningLotto , int bonusNumber) implements LottoConstant {
    public LottoDraw(Lotto winningLotto , int bonusNumber){
        validateBonusNumber(bonusNumber);
        validateLottoContainBonusNumber(winningLotto,bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
    private static void validateBonusNumber(int bonusNumber){
        validateNumberInRange(bonusNumber);
    }
    private static void validateNumberInRange(int number){
        if (number<MIN_NUMBER || number>MAX_NUMBER){
            throw new LottoException(LottoExceptionMessage.INVALID_NUMBER);
        }
    }
    private static void validateLottoContainBonusNumber(Lotto winningLotto,int bonusNumber){
        if (winningLotto.getNumbers().contains(bonusNumber)){
            throw new LottoException(LottoExceptionMessage.DUPLICATE_BONUS_NUMBER);
        }
    }
}