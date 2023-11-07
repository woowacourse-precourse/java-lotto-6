package lotto.Model.Util;

import System.Constant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Model.Domain.Lotto;

public class LottoUtil {

    public Lotto pickLottoNumber() {
        List<Integer> lotto = new ArrayList<>();

        while (lotto.size() < 6) {
            int number = getRandomNumber();

            if (!lotto.contains(number)) {
                lotto.add(number);
            }
        }

        return new Lotto(lotto);
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(Constant.LOTTO_MIN_VALUE.getConstant(),
                Constant.LOTTO_MAX_VALUE.getConstant());
    }

    public boolean checkPurchaseAmount(int money) {
        return money % Constant.LOTTO_PRICE.getConstant() == 0;
    }

    public int calculateCount(int money) {
        return money / Constant.LOTTO_PRICE.getConstant();
    }


}
