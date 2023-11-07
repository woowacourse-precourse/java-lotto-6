package lotto.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.constant.LottoNumberConstant;

public class RandomNumbersGenerator implements RandomGenerator<Integer> {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                LottoNumberConstant.LOTTO_NUMBER_MIN_SIZE.getNumber(),
                LottoNumberConstant.LOTTO_NUMBER_MAX_SIZE.getNumber(),
                LottoNumberConstant.LOTTO_SIZE.getNumber());
    }
}
