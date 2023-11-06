package lotto.domain.num;

import lotto.utill.Utii;

import java.util.List;

public class WinLottoNums {
    private List<Integer> winLottoNums;

    public WinLottoNums(List<Integer> winLottoNums) {

        this.winLottoNums = winLottoNums;
    }

    public Boolean isSameNumOfIndex(Integer target, Integer indexOfSpecial) {
        Integer lottoNumber = winLottoNums.get(indexOfSpecial);

        if (isSame(target, lottoNumber)) {
            return true;
        }

        return false;
    }

    private boolean isSame(Integer num, Integer valueOfIndexSpecial) {
        return Utii.isSameInt(num, valueOfIndexSpecial);
    }
}
