package lotto.service.generator;

import java.util.List;
import lotto.common.constants.LottoRule;
import lotto.util.Random;

public class AutoLottoNumberGenerator implements LottoNumberGenerator {
    @Override
    public List<Integer> generate() {
        return Random.getUniqueNumbersInRange(LottoRule.LOTTO_NUMBER_MIN.value, LottoRule.LOTTO_NUMBER_MAX.value,
                LottoRule.LOTTO_NUMBER_SIZE.value);
    }
}
