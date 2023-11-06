package lotto.util;

import static lotto.util.constant.GameRule.LOTTO_SIZE;
import static lotto.util.constant.GameRule.MAX_LOTTO_RANGE;
import static lotto.util.constant.GameRule.MIN_LOTTO_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class AutomaticGenerator {

    public static List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_RANGE.getValue(),
                MAX_LOTTO_RANGE.getValue(),
                LOTTO_SIZE.getValue());
        Collections.sort(numbers);
        return numbers;
    }

}
