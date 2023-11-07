package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LIST_SIZE = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LIST_SIZE);
    }
}
