package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomGenerator {

    public List<Integer> pickUniqueNumbersInRange(
            final int startInclusive,
            final int endInclusive,
            final int count
    ) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
