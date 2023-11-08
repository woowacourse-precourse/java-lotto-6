package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.LottoConstants;

import java.util.List;

public class RandomsWrapper implements RandomNumberGenerator{
    @Override
    public List<Integer> pickLottoNumberInRange() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstants.LOTTO_MIN_NUMBER.getValue(),
                LottoConstants.LOTTO_MAX_NUMBER.getValue(),
                LottoConstants.LOTTO_SIZE.getValue());
    }

}
