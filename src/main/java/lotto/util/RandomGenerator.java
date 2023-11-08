package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomGenerator {
    private RandomGenerator() {
    }

    public static List<Integer> generateUniqueRandomNumbersInRange(int min, int max, int size) {
        return Randoms.pickUniqueNumbersInRange(min, max, size);
    }
}
