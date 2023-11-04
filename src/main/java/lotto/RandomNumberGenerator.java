package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {

    public static final int MIN = 1;
    public static final int MAX = 45;
    public static final int COUNT = 6;

    static List<Integer> generateUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, COUNT);
    }
}
