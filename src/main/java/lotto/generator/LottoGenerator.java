package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

public class LottoGenerator {
    public Lotto getLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
