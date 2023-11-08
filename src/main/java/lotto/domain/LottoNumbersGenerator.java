package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumbersGenerator {
    private static final int RANDOM_MIN_VALUE = 1;
    private static final int RANDOM_MAX_VALUE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE, LOTTO_NUMBER_COUNT);
    }
}
