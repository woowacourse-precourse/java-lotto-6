package lotto.global.utils.generator;

import static lotto.global.constant.LottoNumberType.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_RANGE_OF_LOTTO.getValue(),
                MAX_RANGE_OF_LOTTO.getValue(),
                LENGTH_OF_LOTTO.getValue()
        );
    }
}
