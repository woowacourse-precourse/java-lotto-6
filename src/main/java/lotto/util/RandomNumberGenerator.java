package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.NumberRange;

public class RandomNumberGenerator {
    public static List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(
                NumberRange.LOWEST_NUMBER.getRangeNumber(),
                NumberRange.HIGHEST_NUMBER.getRangeNumber(),
                NumberRange.LOTTO_NUMBER_COUNT.getRangeNumber());
    }
}
