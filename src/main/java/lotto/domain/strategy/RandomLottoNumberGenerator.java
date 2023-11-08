package lotto.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.LottoConstants;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstants.MIN_NUMBER,
                LottoConstants.MAX_NUMBER,
                LottoConstants.LOTTO_COUNT
        );
    }
}
