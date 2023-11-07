package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constants.LottoConstants;

public class LottoGenerator {
    public List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_LOTTO_NUMBER, LottoConstants.MAX_LOTTO_NUMBER,
                LottoConstants.LOTTO_NUMBER_COUNT);
    }
}
