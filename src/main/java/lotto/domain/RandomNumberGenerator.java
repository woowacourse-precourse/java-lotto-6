package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RandomNumberGenerator {

    private static final int STARTINCLUSIVE = 1;
    private static final int ENDINCLUSIVE = 45;
    private static final int COUNT = 6;

    public static List<Integer> createUniqueRandomNumbers() {
        List<Integer> randomNumbers = pickUniqueNumbersInRange(STARTINCLUSIVE, ENDINCLUSIVE, COUNT);
        return sortRandomNumbers(new ArrayList<>(randomNumbers));
    }

    private static List<Integer> sortRandomNumbers(List<Integer> randomNumbers) {
        Collections.sort(randomNumbers, Comparator.naturalOrder());
        return randomNumbers;
    }


}
