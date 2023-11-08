package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public final class RandomNumberGenerator {
    private RandomNumberGenerator() {
    }
    public static List<Integer> pickUniqueRandomNumbersInRange(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
