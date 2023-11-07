package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Generator {

    public static List<Integer> generateNumbers(int start, int end, int count) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(start, end, count);
        return numbers;
    }
}
