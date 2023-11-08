package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.model.Lotto;

public class LottoRandomGenerator implements LottoGenerateStrategy {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;
    private static final int NUMBER_COUNT = 6;

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(RANGE_START, RANGE_END, NUMBER_COUNT);
    }

    @Override
    public Lotto generate() {
        return new Lotto(createRandomNumbers());
    }
}
