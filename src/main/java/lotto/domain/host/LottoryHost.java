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
     * 중복되는 당첨 번호가 있는지 확인한다.
     *
     * @return
     */
    public Boolean checkDuplicateWinNum(String num) {
        return false;
    }

    /**
     * 중복되는 보너스 번호가 있는지 확인한다.
     *
     * @return
     */
    public Boolean checkDulicateBonusNum(String num) {
        return false;
    }
}
