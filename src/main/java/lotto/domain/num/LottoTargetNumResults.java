package lotto.domain.num;

import lotto.config.Config;
import lotto.utill.Utii;

import java.util.List;

public class LottoTargetNumResults {
    // TODO: 11/6/23 상수 관리 
    private static final Integer BONUS_INDEX_NUM = 6;
    private static final Integer START_PICK_NUM_INDEX = 0;
    private static final Integer END_PICK_NUM_INDEX = 5;
    private static final Integer SIZE_WIN_NUMBERS = 6;
    private WinLottoNums winLottoNums;
    private BonusLottoNum bonusLottoNum;

    public LottoTargetNumResults(List<Integer> winNumbers, Integer bonusNumber) {
        this.winLottoNums = Config.winLottoNums(winNumbers);
        this.bonusLottoNum = Config.bonusLottoNum(bonusNumber);
    }

    public Boolean isSameWinNums(Integer targetNum) {
        for (int index = 0; index < SIZE_WIN_NUMBERS; index++) {
            if (isContainWinLottoNums(targetNum, index)) {
                return true;
            }
        }

        return false;
    }

    private Boolean isContainWinLottoNums(Integer targetNum, int index) {
        return winLottoNums.isSame(targetNum, index);
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
