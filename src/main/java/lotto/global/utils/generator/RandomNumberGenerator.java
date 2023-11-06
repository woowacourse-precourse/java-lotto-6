package lotto.global.utils.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MIN_NUMBER_OF_RANGE = 1;
    private static final int MAX_NUMBER_OF_RANGE = 45;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER_OF_RANGE, MAX_NUMBER_OF_RANGE, 6);
    }
}
