package lotto.domain.host;

import lotto.config.Config;
import lotto.domain.num.LottoNumResults;
import lotto.domain.num.WinLottoNums;

public class LottoryHost {
    private LottoNumResults lottoNumResults;

    public void pickNum(String strOfPickWinNum, String strOfPickBonusNum) {
        this.lottoNumResults = Config.lottoNumResults(strOfPickWinNum, strOfPickBonusNum);
    }

    /**
     * 중복되는 번호가 있는지 확인한다.
     *
     * @return
     */
    // TODO: 11/5/23 삭제 
//    public Boolean checkDuplicateWinNum(String targetNum) {
//        Boolean isSame = false;
//        Integer target = Integer.valueOf(targetNum);
//
//        for (int indexOfSpecial = 0; indexOfSpecial < 7; indexOfSpecial++) {
//            isSame = lottoNumResults.isSame(target, indexOfSpecial);
//            if (isSame) {
//                return true;
//            }
//        }
//
//        return false;
//    }
}
