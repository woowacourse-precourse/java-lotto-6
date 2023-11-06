package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoGenerator {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int LOTTO_SIZE = 6;

    public List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, LOTTO_SIZE);
    }
}

