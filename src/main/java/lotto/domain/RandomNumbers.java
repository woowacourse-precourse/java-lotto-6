package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class RandomNumbers {
    private static final int NUMBER_LENGTH = 6;
    private static final int NUMBER_MAX_SIZE = 45;
    private static final int NUMBER_MIN_SIZE = 1;


    public RandomNumbers() {
    }

    public static List<Integer> generateRandomNumbers() {
        return pickUniqueNumbersInRange(NUMBER_MIN_SIZE,NUMBER_MAX_SIZE,NUMBER_LENGTH);
    }
}
