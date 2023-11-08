package lotto.domain.model.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.LottoConfig;

import java.util.List;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Integer> create() {
        return Randoms.pickUniqueNumbersInRange(LottoConfig.LOTTO_NUMBER_MIN.getValue(),
                LottoConfig.LOTTO_NUMBER_MAX.getValue(), LottoConfig.LOTTO_NUMBERS_SIZE.getValue());
    }
}
