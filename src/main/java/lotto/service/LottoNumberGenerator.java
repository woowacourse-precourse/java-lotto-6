package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.config.AppConfig;

public class LottoNumberGenerator {
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                AppConfig.LOTTO_NUMBER_MIN_RANGE,
                AppConfig.LOTTO_NUMBER_MAX_RANGE,
                AppConfig.LOTTO_SIZE
        );
    }
}
