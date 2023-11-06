package lotto.util;

import static lotto.constant.Constant.LOTTO_CNT;
import static lotto.constant.Constant.LOTTO_MAX_VALUE;
import static lotto.constant.Constant.LOTTO_MIN_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoRandomNumbersGenerator {

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_VALUE, LOTTO_MAX_VALUE, LOTTO_CNT);
    }
}
