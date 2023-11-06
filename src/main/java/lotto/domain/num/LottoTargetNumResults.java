package lotto.domain.num;

import lotto.config.Config;
import lotto.utill.Utii;

import java.util.List;

public class LottoTargetNumResults {
    private static final Integer BONUS_INDEX_NUM = 6;
    private static final Integer START_PICK_NUM_INDEX = 0;
    private static final Integer END_PICK_NUM_INDEX = 5;
    private WinLottoNums winLottoNums;
    private BonusLottoNum bonusLottoNum;

    public LottoTargetNumResults(List<Integer> winNumbers, Integer bonusNumber) {
        this.winLottoNums = Config.winLottoNums(winNumbers);
        this.bonusLottoNum = Config.bonusLottoNum(bonusNumber);
    }

    // TODO: 11/5/23 삭제 해도 될꺼 같다. 확인 
//    public Boolean isSame(Integer targetNum, Integer indexOfSpecial) {
//        if (isContainScopeOfWinNums(indexOfSpecial)) {
//            return isSameWinNums(targetNum, indexOfSpecial);
//        }
//        return isSameBonusNum(targetNum, indexOfSpecial);
//    }

    /**
     * 당첨 번호 추첨 번호가 같은지 확인한다.
     *
     * @param targetNum 확인하기 위한 번호
     * @return
     */
    public Boolean isSameWinNums(Integer targetNum) {
        for (int index = 0; index < 6; index++) {
            if (winLottoNums.isSame(targetNum, index)) {
                return true;
            }
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
        if (Utii.isSameInt(indexOfSpecial, BONUS_INDEX_NUM)) {
            return bonusLottoNum.isSame(targetNum);
        }

        return false;
    }

    private boolean isContainScopeOfWinNums(Integer indexOfSpecial) {
        return indexOfSpecial >= START_PICK_NUM_INDEX
                && indexOfSpecial <= END_PICK_NUM_INDEX;
    }

}
