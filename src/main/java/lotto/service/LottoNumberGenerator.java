package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.config.Constants;

public class LottoNumberGenerator {

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_NUMBER_MIN_RANGE,
                Constants.LOTTO_NUMBER_MAX_RANGE,
                Constants.LOTTO_SIZE
        );
    }
}
