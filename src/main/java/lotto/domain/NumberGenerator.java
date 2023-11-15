package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {
    private static final int MIN_LOTTO_VALUE = 1;
    private static final int MAX_LOTTO_VALUE = 45;
    private static final int LOTTO_SIZE = 6;

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_VALUE,
                MAX_LOTTO_VALUE,
                LOTTO_SIZE
        );

        List<Integer> result = new ArrayList<>(numbers);
        Collections.sort(result);
        return result;
    }
}
