package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator implements RandomNumberGenerator{
    private final int MIN_NUM = 1;
    private final int MAX_NUM = 45;
    private final int NUM_COUNT = 6;
    @Override
    public List<Integer> makeRandom() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, NUM_COUNT);
    }
}
