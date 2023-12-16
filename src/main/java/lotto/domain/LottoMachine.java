package lotto.domain;

import static lotto.domain.LottoDetails.LOTTO_MAXIMUM;
import static lotto.domain.LottoDetails.LOTTO_MINIMUM;
import static lotto.domain.LottoDetails.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    public static Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MINIMUM, LOTTO_MAXIMUM, LOTTO_SIZE));
    }
}
