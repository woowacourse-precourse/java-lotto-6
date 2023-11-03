package lotto.util;

import static lotto.constant.LottoInfo.MAXIMUM_NUMBER;
import static lotto.constant.LottoInfo.MINIMUM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    public static int generateNumber() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER.getInfo(), MAXIMUM_NUMBER.getInfo());
    }

}
