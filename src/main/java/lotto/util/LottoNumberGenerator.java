package lotto.util;

import static lotto.constant.NumberConstant.LOTTO_MAX_NUMBER;
import static lotto.constant.NumberConstant.LOTTO_MIN_NUMBER;
import static lotto.constant.NumberConstant.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE));
        Collections.sort(numbers);
        return numbers;
    }
}
