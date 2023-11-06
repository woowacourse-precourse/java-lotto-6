package lotto.util;

import static lotto.domain.LottoRule.MAXIMUM;
import static lotto.domain.LottoRule.MINIMUM;
import static lotto.domain.LottoRule.SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements Generator {

    @Override
    public List<Integer> generate() {
        List<Integer> randomNumber = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(MINIMUM.getValue(), MAXIMUM.getValue(), SIZE.getValue()));
        return randomNumber;
    }
}
