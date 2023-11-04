package lotto.domain;

import static lotto.domain.LottoDetails.lottoNumberMinimum;
import static lotto.domain.LottoDetails.lottoNumberMaximum;
import static lotto.domain.LottoDetails.lottoSize;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {

    public static Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                lottoNumberMinimum(),
                lottoNumberMaximum(),
                lottoSize())
        );
    }
}
