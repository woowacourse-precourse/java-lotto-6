package lotto;

import static lotto.LottoRule.MAXIMUM;
import static lotto.LottoRule.MINIMUM;
import static lotto.LottoRule.SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements Generator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM.getValue(), MAXIMUM.getValue(), SIZE.getValue());
    }
}
