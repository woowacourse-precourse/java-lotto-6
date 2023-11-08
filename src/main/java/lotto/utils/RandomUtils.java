package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.UtilsConstant;

import java.util.List;

public class RandomUtils {

    public static List<Integer> makeRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(UtilsConstant.RANDOM_START_NUMBER,UtilsConstant.RANDOM_END_NUMBER,UtilsConstant.RANDOM_COUNT_NUMBER);
    }

}
