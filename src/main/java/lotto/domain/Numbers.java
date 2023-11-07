package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Numbers {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int NUMBER_COUNTER = 6;

    public static List<Integer> pickRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNTER);
    }
}
