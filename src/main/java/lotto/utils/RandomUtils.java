package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import static lotto.constant.UtilsConstant.*;

import java.util.List;

public class RandomUtils {

    public static List<Integer> makeRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(RANDOM_START_NUMBER,RANDOM_END_NUMBER,RANDOM_COUNT_NUMBER);
    }
}
