package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

public class GenerateLotto {

    private static Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

}
