package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class RandomNumbersGenerator {

    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;
    private final static int LENGTH = 6;

    private RandomNumbersGenerator() {
    }

    public static List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LENGTH);
        Collections.sort(numbers);
        return Collections.unmodifiableList(numbers);
    }
}
