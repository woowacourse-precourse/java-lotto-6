package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerator {

    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final int NUMBER_SIZE = 6;

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, NUMBER_SIZE);
    }

}
