package util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

class NumberGenerator {
    private NumberGenerator() {
    }

    static Lotto generateNumbers()
    {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
    }
}
