package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Random {
    private Random() {
    }

    public static List<Integer> getUniqueNumbersInRange(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }
}
