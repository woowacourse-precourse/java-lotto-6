package lotto.domain;

import lotto.config.LottoRank;
import lotto.validation.WinningNumValidator;

import java.util.ArrayList;

public class WinningNum {
    private final ArrayList<Integer> winningNum;
    private Integer bonusNumber;

    public WinningNum(ArrayList<Integer> winningNum) {
        WinningNumValidator.validate(winningNum);

        this.winningNum = winningNum;
    }

    public void setBonusNumber(Integer number) {
        WinningNumValidator.bonusValidate(winningNum, number);

        this.bonusNumber = number;
    }

    public Integer compare(Lotto lotto) {
        Integer count = 0;
        Boolean bonus = false;
        for (Integer num : winningNum) {
            if(lotto.hasNumber(num)){
                count++;
            }
        }

        if(lotto.hasNumber(bonusNumber)) bonus = true;

        return getRank(count,bonus);
    }

    private Integer getRank(int count,Boolean bonus) {
        if(count==6) return LottoRank.FIRST.getNum();
        if (count == 5) {
            if(bonus) return LottoRank.SECOND.getNum();

            return LottoRank.THIRD.getNum();
        }
        if (count==4) return LottoRank.FOURTH.getNum();
        if(count==3) return LottoRank.FIFTH.getNum();

        return -1;
    }
}
