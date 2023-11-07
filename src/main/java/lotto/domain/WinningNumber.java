package lotto.domain;

import static lotto.domain.LottoConstraint.MAX_LOTTO_NUM;
import static lotto.domain.LottoConstraint.MIN_LOTTO_NUM;
import static lotto.exception.LottoErrorMsg.BONUS_DUPLICATED;
import static lotto.exception.LottoErrorMsg.OUT_OF_RANGE;

import lotto.exception.LottoException;

public class WinningNumber{

    private final Lotto winningNum;
    private final int BonusNum;

    public WinningNumber(Lotto winningNum, int bonusNum){
        validate(winningNum,bonusNum);
        this.winningNum = winningNum;
        this.BonusNum = bonusNum;

    }

    public Lotto getWinningNum() {
        return winningNum;
    }

    public int getBonusNum() {
        return BonusNum;
    }

    private void validate(Lotto winningNum, int bonusNumber){
        if (bonusNumber < MIN_LOTTO_NUM || bonusNumber > MAX_LOTTO_NUM ){
            throw LottoException.triggeredBy(OUT_OF_RANGE);
        }
        for (int num : winningNum.getNumbers()){
            if (num == bonusNumber){
                throw LottoException.triggeredBy(BONUS_DUPLICATED);
            }
        }
    }
}
