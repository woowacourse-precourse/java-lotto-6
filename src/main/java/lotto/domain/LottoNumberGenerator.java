package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.constants.LottoRule;
import lotto.util.NumberGenerator;

import java.util.List;

public class LottoNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> pickUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoRule.LOTTO_MIN_NUMBER.getValue(),
                LottoRule.LOTTO_MAX_NUMBER.getValue(),
                LottoRule.LOTTO_SIZE.getValue()
        );
    }
}
