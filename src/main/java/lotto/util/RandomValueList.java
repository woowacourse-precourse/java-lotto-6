package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomValueList {
    public static List<Integer> getRandomValue() {
        return Randoms.pickUniqueNumbersInRange(Constant.MIN_LOTTO_VALUE, Constant.MAX_LOTTO_VALUE, Constant.LOTTO_NUMBER);
    }
}
