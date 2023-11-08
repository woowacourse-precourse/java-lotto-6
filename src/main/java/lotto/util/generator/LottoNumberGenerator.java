package lotto.util.generator;

import static lotto.common.Constant.LOTTO_NUMBERS_SIZE;
import static lotto.common.Constant.MAX_RANGE;
import static lotto.common.Constant.MIN_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_NUMBERS_SIZE);
    }
}
