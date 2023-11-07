package lotto.common;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;
    public static final int RANDOM_NUMBER_COUNT = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, RANDOM_NUMBER_COUNT);
    }
}
