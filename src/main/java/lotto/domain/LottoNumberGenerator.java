package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.common.consts.SystemConsts;

public class LottoNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generator() {
        return Randoms.pickUniqueNumbersInRange(SystemConsts.RANDOM_RNAGE_START, SystemConsts.RANDOM_RNAGE_END,
                SystemConsts.RANDOM_NUMBERS_SIZE);
    }
}
