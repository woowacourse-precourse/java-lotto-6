package lotto.utils.random;

import static lotto.utils.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.utils.constant.LottoConstant.LOTTO_NUMBER_MAX;
import static lotto.utils.constant.LottoConstant.LOTTO_NUMBER_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {
    }

    public static List<Integer> getRandomNumbersInLottoRange() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN.getValue(), LOTTO_NUMBER_MAX.getValue(),
                LOTTO_NUMBER_COUNT.getValue());
    }
}
