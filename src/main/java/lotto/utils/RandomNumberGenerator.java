package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constants.Values;

public class RandomNumberGenerator {

    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(Values.LOTTO_MIN_NUMBER,
                Values.LOTTO_MAX_NUMBER, Values.LOTTO_NUMBER_COUNT);
    }
}
