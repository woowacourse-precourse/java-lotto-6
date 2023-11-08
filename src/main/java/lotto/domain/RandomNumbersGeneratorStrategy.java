package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersGeneratorStrategy implements NumbersGeneratorStrategy {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;
    private static final int COUNT = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LOWER_BOUND, UPPER_BOUND, COUNT);
    }
}
