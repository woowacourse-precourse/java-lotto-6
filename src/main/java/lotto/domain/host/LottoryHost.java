package lotto.domain.host;

import lotto.domain.num.LottoNumResults;
import lotto.domain.num.WinLottoNums;

public class LottoryHost {
    private LottoNumResults lottoNumResults;
    private String numsOfWin;
    private String numOfBonus;

    /**
     * 당첨 번호 추첨을 뽑는다.
     *
     * @param strLine 당첨 번호 문자열
     */
    public void pickWinNum(String strLine) {
        this.numsOfWin = strLine;
    }

    /**
     * 보너스 번호를 뽑는다.
     *
     * @param strLine
     */
    public void pickBonusNum(String strLine) {
        this.numOfBonus = strLine;
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
