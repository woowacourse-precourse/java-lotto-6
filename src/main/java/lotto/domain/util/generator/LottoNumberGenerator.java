package lotto.domain.util.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.config.LottoConfig;

public class LottoNumberGenerator {
    private static final int LOTTO_MINIMUM_NUMBER = LottoConfig.LOTTO_MINIMUM_NUMBER.getValue();
    private static final int LOTTO_MAXIMUM_NUMBER = LottoConfig.LOTTO_MAXIMUM_NUMBER.getValue();
    private static final int LOTTO_SIZE = LottoConfig.LOTTO_SIZE.getValue();

    public static List<Integer> createRandom() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER,
                LOTTO_SIZE);
    }
}
