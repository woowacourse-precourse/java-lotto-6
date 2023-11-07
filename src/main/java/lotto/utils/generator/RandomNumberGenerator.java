package lotto.utils.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int SIZE = 6;

    @Override
    public List<Integer> generate() {
        final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, SIZE);
        return Collections.unmodifiableList(numbers);
    }
}
