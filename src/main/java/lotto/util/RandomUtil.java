package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUtil {

    public static List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(Constant.LOTTO_MIN_NUMBER, Constant.LOTTO_MAX_NUMBER, Constant.LOTTO_MAX_LENGTH));
        Collections.sort(numbers);

        return numbers;
    }
}