package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.NumberConstant;

public class RandomNumberGenerator implements NumberGenerator{

    public List<Integer> generateLottoNumbers() {
        List<Integer> randomNumbers =  Randoms.pickUniqueNumbersInRange(
                NumberConstant.LOTTO_MIN_NUMBER.getNumber(),
                NumberConstant.LOTTO_MAX_NUMBER.getNumber(),
                NumberConstant.LOTTO_COUNT.getNumber()
        );
        return randomNumbers;
    }
}
