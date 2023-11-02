package lotto.utils;

import static lotto.contents.ContentNumbers.LOTTO_MAX_NUMBER;
import static lotto.contents.ContentNumbers.LOTTO_MIN_NUMBER;
import static lotto.contents.ContentNumbers.LOTTO_NUMBERS_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomGeneratorUtil {
    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER.getNumber(), LOTTO_MAX_NUMBER.getNumber(),
                LOTTO_NUMBERS_COUNT.getNumber());
    }
}
