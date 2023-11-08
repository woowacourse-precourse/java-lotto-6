package lotto.domain.numbergenerator;

import static lotto.domain.util.Constant.LOTTO_COUNT;
import static lotto.domain.util.Constant.MAX_LOTTO_NUMBER;
import static lotto.domain.util.Constant.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT);
    }
}
