package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.config.LottoConfig;
import lotto.domain.Lotto;

public class LottoGenerator {
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
