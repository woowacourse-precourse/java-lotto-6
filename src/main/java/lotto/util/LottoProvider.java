package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.policy.LottoPolicy;

public class LottoProvider {

    public static Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                LottoPolicy.MIN_LOTTO_NUMBER.getValue(),
                LottoPolicy.MAX_LOTTO_NUMBER.getValue(),
                LottoPolicy.LOTTO_NUMBER_COUNT.getValue())
        );
    }

    private LottoProvider() {
    }
}
