package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.config.LottoConfig;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoConfig.MIN_NUMBER, LottoConfig.MAX_NUMBER, LottoConfig.MAX_BALLS);
    }
}
