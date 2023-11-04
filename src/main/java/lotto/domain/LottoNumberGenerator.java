package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator implements NumberGenerator {
    private static final int RANDOM_RNAGE_START = 0;
    private static final int RANDOM_RNAGE_END = 45;
    private static final int RANDOM_NUMBERS_SIZE = 6;

    @Override
    public List<Integer> generator() {
        return Randoms.pickUniqueNumbersInRange(RANDOM_RNAGE_START, RANDOM_RNAGE_END, RANDOM_NUMBERS_SIZE);
    }
}
