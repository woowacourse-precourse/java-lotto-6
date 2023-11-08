package lotto.Utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumber {
    private static final int startNumber = 1;
    private static int endNumber = 45;
    private static final int count = 6;

    public static List<Integer> generator() {
        return Randoms.pickUniqueNumbersInRange(startNumber, endNumber, count);
    }
}
