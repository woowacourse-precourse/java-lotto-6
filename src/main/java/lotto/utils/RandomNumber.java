package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;

public class RandomNumber {
    private static int START_INCLUSIVE = 1;
    private static int END_INCLUSIVE = 45;
    private static int COUNT = 6;

    public static List<Integer> generator() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
