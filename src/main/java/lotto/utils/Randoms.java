package lotto.utils;

import java.util.List;

public class Randoms {

    private static final int MINIMUM_NUMBER_RANGE = 1;
    private static final int MAXIMUM_NUMBER_RANGE = 45;
    private static final int RANDOM_NUMBER_COUNT = 6;

    public static List<Integer> pickUniqueNumbersInRange() {
        List<Integer> numbers = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(
                MINIMUM_NUMBER_RANGE, MAXIMUM_NUMBER_RANGE, RANDOM_NUMBER_COUNT);

        return List.copyOf(numbers);
    }
}
