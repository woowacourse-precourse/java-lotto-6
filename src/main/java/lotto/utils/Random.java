package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.consts.Constants;

import java.util.List;

public class Random {

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(Constants.LOTTO_RANGE_START, Constants.LOTTO_RANGE_END, Constants.COUNT_NO_BONUS);
    }
}
