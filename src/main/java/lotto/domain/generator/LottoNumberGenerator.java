package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.domain.lotto.LottoCondition.*;

public class LottoNumberGenerator implements NumberGenerator {

    private LottoNumberGenerator() {
    }

    private static class NumberGeneratorHolder {
        private static LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    }

    public static LottoNumberGenerator getInstance() {
        return NumberGeneratorHolder.lottoNumberGenerator;
    }

    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue(), COUNT.getValue());
    }
}
