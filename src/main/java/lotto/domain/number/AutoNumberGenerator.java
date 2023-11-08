package lotto.domain.number;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class AutoNumberGenerator implements LottoNumberGenerator {

    @Override
    public Lotto getLottoNumbers() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
