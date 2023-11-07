package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constants.LottoConstants;

public class LottoNumbersGenerator {

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.RANDOM_MIN_NUMBER.getNumber(),
                LottoConstants.RANDOM_MAX_NUMBER.getNumber(),
                LottoConstants.COUNT.getNumber());
    }
}
