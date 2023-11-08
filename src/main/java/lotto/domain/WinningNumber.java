package lotto.domain;

import static lotto.domain.LottoConstraint.MAX_LOTTO_NUM;
import static lotto.domain.LottoConstraint.MIN_LOTTO_NUM;
import static lotto.exception.LottoErrorMsg.BONUS_DUPLICATED;
import static lotto.exception.LottoErrorMsg.OUT_OF_RANGE;

import java.util.Arrays;
import lotto.exception.LottoException;

public class WinningNumber{

    private final Lotto winningNum;
    private final int bonusNum;

    private boolean[] WinningNum =new boolean[MAX_LOTTO_NUM +1];

    public WinningNumber(Lotto winningNum, int bonusNum){
        validate(winningNum,bonusNum);
        this.winningNum = winningNum;
        this.bonusNum = bonusNum;
        Arrays.fill(WinningNum,false);
        for (int lottoNum: winningNum.getNumbers()){
            WinningNum[lottoNum] = true;
        }


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
    public int findMatchingNumber(Lotto lotto){
        int cnt = 0;
        for (int number:lotto.getNumbers()){
            if(isWinningNumber(number)){
                cnt+=1;
            }
        }
        return cnt;
    }
    public boolean isWinningNumber(int number){
        return WinningNum[number];
    }
    public boolean isBonusNumber(Lotto lotto){
        for (int num: lotto.getNumbers()){
            if (num == bonusNum){
                return true;
            }
        }
        return false;
    }

}
