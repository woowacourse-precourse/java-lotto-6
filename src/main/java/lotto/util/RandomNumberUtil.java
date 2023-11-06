package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class RandomNumberUtil {

    public static List<Integer> generateAndSortUniqueNumbersInRange(int startNumber, int endNumber, int count) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startNumber, endNumber, count);
        Collections.sort(numbers);

        return numbers;
    }
}
