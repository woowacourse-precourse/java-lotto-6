package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberUtil {

    private NumberUtil() {}

    public static final List<Integer> numberGenerator(int min, int max, int size) {
        return Randoms.pickUniqueNumbersInRange(min, max, size);
    }
}
