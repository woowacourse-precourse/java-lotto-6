package lotto.util;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.domain.lotto.LottoRule.MAXIMUM;
import static lotto.domain.lotto.LottoRule.MINIMUM;
import static lotto.domain.lotto.LottoRule.SIZE;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements Generator {

    @Override
    public List<Integer> generate() {
        List<Integer> randomNumber = new ArrayList<>(
                pickUniqueNumbersInRange(MINIMUM.getValue(), MAXIMUM.getValue(), SIZE.getValue()));
        return randomNumber;
    }
}
