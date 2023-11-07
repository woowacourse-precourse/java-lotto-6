package lotto.Model.Util;

import System.Constant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import lotto.Model.Domain.Lotto;

public class LottoUtil {

    public Lotto pickLottoNumber() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(
                Constant.LOTTO_MIN_VALUE.getConstant(), Constant.LOTTO_MAX_VALUE.getConstant(),
                Constant.LOTTO_SIZE.getConstant());

        lotto.sort(Comparator.naturalOrder());

        return new Lotto(lotto);
    }

    public boolean checkPurchaseAmount(int money) {
        return money % Constant.LOTTO_PRICE.getConstant() == 0;
    }

    public int calculateCount(int money) {
        return money / Constant.LOTTO_PRICE.getConstant();
    }


}
