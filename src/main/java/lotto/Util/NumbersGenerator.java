package lotto.Util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NumbersGenerator {
    public static final int MIN_NUMBER_RANGE = 1;
    public static final int MAX_NUMBER_RANGE = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        numbers.sort(Integer::compareTo);
        return numbers;
    }
}
