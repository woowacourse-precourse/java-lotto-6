package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConfig;

import java.util.List;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Integer> create() {
        return Randoms.pickUniqueNumbersInRange(LottoConfig.LOTTO_NUMBER_MIN, LottoConfig.LOTTO_NUMBER_MAX, LottoConfig.LOTTO_NUMBERS_SIZE);
    }
}
