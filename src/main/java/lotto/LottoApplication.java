package lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoApplication {
    Lotto drawLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(Lotto.START_NUMBER, Lotto.END_NUMBER, 6));
    }
}
