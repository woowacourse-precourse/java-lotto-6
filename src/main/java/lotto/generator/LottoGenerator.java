package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.LottoConstants;

public class LottoGenerator {
    public Lotto getLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_LOTTO_NUMBER, LottoConstants.MAX_LOTTO_NUMBER, LottoConstants.LOTTO_LENGTH));
    }
}
