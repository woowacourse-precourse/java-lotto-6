package lotto.util;

import static lotto.domain.LottoRule.MAXIMUM;
import static lotto.domain.LottoRule.MINIMUM;
import static lotto.domain.LottoRule.SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements Generator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM.getValue(), MAXIMUM.getValue(), SIZE.getValue());
    }
}
