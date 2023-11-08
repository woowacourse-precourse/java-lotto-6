package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {
    private static final int NUM_OF_LOTTO = 6;
    private static final int START_NUM_OF_LOTTO = 1;
    private static final int END_NUM_OF_LOTTO = 45;

    public List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(START_NUM_OF_LOTTO, END_NUM_OF_LOTTO, NUM_OF_LOTTO);
    }
}
