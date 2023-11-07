package lotto.util;

import static lotto.constant.LottoInfo.LOTTO_SIZE;
import static lotto.constant.LottoInfo.MAXIMUM_NUMBER;
import static lotto.constant.LottoInfo.MINIMUM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomGenerator {

    public static List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER.getInfo(), MAXIMUM_NUMBER.getInfo(),
                LOTTO_SIZE.getInfo());
    }
    
}
