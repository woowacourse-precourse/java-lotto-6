package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {

    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;
    private static final int LENGTH = 6;

    public List<Integer> generateUniqueSortedNumbers() {
        List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE, LENGTH);
        Collections.sort(uniqueNumbers);
        return uniqueNumbers;
    }
}
