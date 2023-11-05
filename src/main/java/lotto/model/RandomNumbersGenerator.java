package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbersGenerator {

    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;
    private final static int LENGTH = 6;

    private RandomNumbersGenerator() {
    }

    public static List<Integer> generate() {
        List<Integer> randomPickNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LENGTH);
        List<Integer> numbers = new ArrayList<>(randomPickNumbers);
        Collections.sort(numbers);
        return Collections.unmodifiableList(numbers);
    }
}
