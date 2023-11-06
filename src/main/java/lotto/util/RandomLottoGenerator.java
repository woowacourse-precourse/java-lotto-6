package lotto.util;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.util.Constants.LOTTO_NUMBERS_SIZE;
import static lotto.util.Constants.LOTTO_NUMBER_MAX_RANGE;
import static lotto.util.Constants.LOTTO_NUMBER_MIN_RANGE;

import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {
    @Override
    public List<Integer> generateNumber() {
        return pickUniqueNumbersInRange(LOTTO_NUMBER_MIN_RANGE, LOTTO_NUMBER_MAX_RANGE, LOTTO_NUMBERS_SIZE);
    }
}
