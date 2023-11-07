package lotto.domain.number;

import lotto.utill.Utii;

import java.util.List;

public class WinLottoNumbers {
    private List<Integer> winLottoNums;

    public WinLottoNumbers(List<Integer> winLottoNums) {

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
