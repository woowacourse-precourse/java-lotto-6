package lotto.util;

import static lotto.util.Constant.END_INCLUSIVE;
import static lotto.util.Constant.LOTTO_NUMBER_COUNT;
import static lotto.util.Constant.START_INCLUSIVE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE.getValue(), END_INCLUSIVE.getValue(),
                LOTTO_NUMBER_COUNT.getValue());
    }
}
