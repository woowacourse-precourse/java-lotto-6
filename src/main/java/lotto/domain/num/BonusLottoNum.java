package lotto.domain.num;

import lotto.utill.Utii;

/**
 * 보너스 번호 클래스
 */
public class BonusLottoNum {
    private Integer bonusNum;

    public BonusLottoNum(Integer bonusNumber) {
        this.bonusNum = bonusNumber;
    }

    /**
     * 보너스 번호가 같은지 확인한다.
     *
     * @param num 같은지 확인하고 싶은 번호
     * @return
     */
    public Boolean isSame(Integer num) {
        return Utii.isSameInt(bonusNum, num);
    }
}
