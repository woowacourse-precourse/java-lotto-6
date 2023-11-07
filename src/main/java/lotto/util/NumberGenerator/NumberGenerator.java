package lotto.util.NumberGenerator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConfig;

import java.util.List;

public class NumberGenerator implements INumberGenerator {

    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConfig.LOTTO_NUMBER_FROM,
                LottoConfig.LOTTO_NUMBER_TO,
                LottoConfig.LOTTO_LENGTH
        );
    }

}
