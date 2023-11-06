package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomUtil {
    public static List<Integer> createRandomNumbersInRange(int min, int max, int size) {
        return Randoms.pickUniqueNumbersInRange(min, max, size);
    }
}