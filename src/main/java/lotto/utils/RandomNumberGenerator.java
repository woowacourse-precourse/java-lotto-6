package lotto.utils;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Numbers;

public class RandomNumberGenerator {
    private RandomNumberGenerator() {
    }
    public static List<Integer> pickUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(Numbers.RANGE_MIN_NUMBER, Numbers.RANGE_MAX_NUMBER, Numbers.VALID_SIZE);
    }
}
