package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbers {
    private static final int RANDOM_MIN_VALUE = 1;
    private static final int RANDOM_MAX_VALUE = 45;
    private static final int RANDOM_NUMBERS_SIZE = 6;

    public List<Integer> generateRandomNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(RANDOM_MIN_VALUE,
                RANDOM_MAX_VALUE, RANDOM_NUMBERS_SIZE);
        return lottoNumbers;
    }
}
