package lotto.domain.num;

import lotto.utill.Utii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 당첨 번호와 보너스 번호들의 모임 클래스
 */
public class LottoNumResults {
    private WinLottoNums winLottoNums;
    private BonusLottoNum bonusLottoNum;
    private Boolean isSame;

    public LottoNumResults(WinLottoNums winLottoNums, BonusLottoNum bonusLottoNum) {
        this.winLottoNums = winLottoNums;
        this.bonusLottoNum = bonusLottoNum;
        isSame = false;
    }

    public Boolean isSame(Integer targetNum, Integer indexOfSpecial) {
        isSame = isSamePickNum(targetNum, indexOfSpecial);
        isSame = isSameBonusNum(targetNum, indexOfSpecial);

        return null;
    }

    /**
     * 당첨 번호 추첨 번호가 같은지 확인한다.
     *
     * @param targetNum 확인하기 위한 번호
     * @return
     */
    public Boolean isSamePickNum(Integer targetNum, Integer indexOfSpecial) {

        if (indexOfSpecial >= 0 && indexOfSpecial <= 5) {
            return winLottoNums.isSame(targetNum, indexOfSpecial);
        }

        return false;
    }

    /**
     * 보너스 번호가 같은지 확인
     *
     * @param targetNum
     * @return
     */
    public Boolean isSameBonusNum(Integer targetNum, Integer indexOfSpecial) {
        if (Utii.isSameInt(indexOfSpecial, 6)) {
            return bonusLottoNum.isSame(targetNum);
        }
        
        return false;
    }
}
