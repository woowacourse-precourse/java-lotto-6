package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.LottoConfig;
import lotto.domain.Lotto;

public class RandomLottoGenerator implements LottoGenerator {
    public Lotto generate(){
        return new Lotto(Randoms.pickUniqueNumbersInRange
                (LottoConfig.LOTTO_NUMBER_START_INCLUSIVE.getValue(),
                LottoConfig.LOTT0_NUMBER_END_INCLUSIVE.getValue(),
                LottoConfig.LOTTO_NUMBER_COUNT.getValue())
                .stream()
                .sorted()
                .toList());
    }
}
