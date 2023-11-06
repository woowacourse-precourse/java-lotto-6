package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NumberGenerator {
    private static final int NUMBER_MIN_VALUE = 1;
    private static final int NUMBER_MAX_VALUE = 45;
    private static final int NUMBER_COUNT = 6;

    public void generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(NUMBER_MIN_VALUE, NUMBER_MAX_VALUE,
                NUMBER_COUNT);
    }
}