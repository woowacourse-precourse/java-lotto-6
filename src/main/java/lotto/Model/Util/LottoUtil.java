package lotto.Model.Util;

import System.Constant;
import System.Exception;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import lotto.Model.Domain.Lotto;

public class LottoUtil {

    public Lotto pickLottoNumber() {
        List<Integer> lottos = Randoms.pickUniqueNumbersInRange(
                Constant.LOTTO_MIN_VALUE.getConstant(), Constant.LOTTO_MAX_VALUE.getConstant(),
                Constant.LOTTO_SIZE.getConstant());

        ArrayList<Integer> sortedLottos = new ArrayList<>(lottos);
        sortedLottos.sort(Comparator.naturalOrder());

        return new Lotto(sortedLottos);
    }

    public void validatePurchaseAmount(String purchaseMoney) {
        if(!Pattern.matches("\\d+", purchaseMoney)) {
            throw new IllegalArgumentException(Exception.LOTTO_PURCHASE_EXCEPTION.getMessage());
        }
    }

    public void checkPurchaseAmount(int money) {
        if(money % Constant.LOTTO_PRICE.getConstant() != 0) {
            throw new IllegalArgumentException(Exception.LOTTO_PURCHASE_EXCEPTION.getMessage());
        }
    }

    public int calculateCount(int money) {
        return money / Constant.LOTTO_PRICE.getConstant();
    }


}
