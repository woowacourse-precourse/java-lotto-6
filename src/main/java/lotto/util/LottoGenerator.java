package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class LottoGenerator {
    public Lotto generate(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
