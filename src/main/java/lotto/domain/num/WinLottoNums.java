package lotto.domain.num;

import lotto.utill.Utii;

import java.util.List;

public class WinLottoNums {
    private List<Integer> winLottoNums;

    public WinLottoNums(List<Integer> winLottoNums) {

        this.winLottoNums = winLottoNums;
    }

    public Boolean isSameNumOfIndex(Integer num, Integer indexOfSpecial) {
        int valueOfIndexSpecial = winLottoNums.get(indexOfSpecial);
        boolean isSame = Utii.isSameInt(num, valueOfIndexSpecial);

        if (isSame) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return winLottoNums.toString();
    }
}
