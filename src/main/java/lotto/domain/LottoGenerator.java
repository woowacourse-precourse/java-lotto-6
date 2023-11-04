package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {

    public static Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
