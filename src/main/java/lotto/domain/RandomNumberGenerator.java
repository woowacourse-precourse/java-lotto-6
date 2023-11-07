package lotto.domain;

import static lotto.constant.LottoConstant.COUNT;
import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue(),
                COUNT.getValue());
    }
}
