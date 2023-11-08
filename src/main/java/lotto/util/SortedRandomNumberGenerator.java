package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class SortedRandomNumberGenerator {
    public static final int START_RANGE = 1;
    public static final int END_RANGE = 45;
    public static final int COUNT = 6;

    public List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, COUNT);
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
