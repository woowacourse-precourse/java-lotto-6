package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomUtil {

    public static List<Integer> getRandomDistinctIntegers(int min, int max, int count) {
        return Randoms.pickUniqueNumbersInRange(min, max, count);
    }
}
