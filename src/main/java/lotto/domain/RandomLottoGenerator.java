package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomLottoGenerator implements LottoGenerator {
    public Lotto generate() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
