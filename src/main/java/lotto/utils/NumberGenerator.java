package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NumberGenerator {
    private NumberGenerator() {
    }

    public static List<Integer> createInRangeNumber(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
