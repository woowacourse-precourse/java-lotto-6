package lotto.domain.num;

import lotto.utill.Utii;

public class BonusLottoNum {
    private Integer bonusNum;

    public BonusLottoNum(Integer bonusNumber) {
        this.bonusNum = bonusNumber;
    }

    public Boolean isSame(Integer num) {
        return Utii.isSameInt(bonusNum, num);
    }
}
