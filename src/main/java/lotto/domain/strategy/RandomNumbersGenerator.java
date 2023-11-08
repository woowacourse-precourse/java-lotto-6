package lotto.domain.strategy;

import static lotto.domain.constant.LottoNumberConstant.LOTTO_NUMBER_MAX_SIZE;
import static lotto.domain.constant.LottoNumberConstant.LOTTO_NUMBER_MIN_SIZE;
import static lotto.domain.constant.LottoNumberConstant.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersGenerator implements RandomGenerator<List<Integer>> {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_MIN_SIZE.getNumber(),
                LOTTO_NUMBER_MAX_SIZE.getNumber(),
                LOTTO_SIZE.getNumber()
        );
    }

}
