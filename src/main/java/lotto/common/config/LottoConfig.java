package lotto.common.config;

import lotto.domain.lottogenerator.LottoGenerator;
import lotto.domain.lottogenerator.RandomLottoGenerator;

public class LottoConfig {

    public LottoGenerator lottoGenerator() {
        return new RandomLottoGenerator();
    }
}
