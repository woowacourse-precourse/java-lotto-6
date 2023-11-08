package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.common.Constant;

public class LottoNumberGenerator {
    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                Constant.LOTTO_MIN_NUM,
                Constant.LOTTO_MAX_NUM,
                Constant.LOTTO_NUM_SIZE);
    }
}
