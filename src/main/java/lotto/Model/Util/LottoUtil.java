package lotto.Model.Util;

import System.Constant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

    public int calculateCount(int money) {
        return money / Constant.LOTTO_PRICE.getConstant();
    }


}
