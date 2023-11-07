package lotto.util;

import static lotto.domain.enums.LottoConstants.LOTTO_SIZE;
import static lotto.domain.enums.LottoConstants.MAX_LOTTO_NUM;
import static lotto.domain.enums.LottoConstants.MIN_LOTTO_NUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
    public RandomNumberGenerator() {

    }

    public static List<Integer> generate() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_SIZE);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}
