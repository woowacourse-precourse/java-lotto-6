package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.lotto.LottoRule;

public class RandomNumbersGenerator implements NumbersGenerator {

    @Override
    public List<Integer> create() {
        return Randoms.pickUniqueNumbersInRange(LottoRule.LOTTO_MIN_NUMBER_INCLUSION.getValue(),
                        LottoRule.LOTTO_MAX_NUMBER_INCLUSION.getValue(),
                        LottoRule.LOTTO_NUMBER_COUNT.getValue())
                .stream()
                .sorted()
                .toList();
    }
}
