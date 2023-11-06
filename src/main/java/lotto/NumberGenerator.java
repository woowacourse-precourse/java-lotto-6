package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerator {

    public List<Integer> generate() {
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 45;
        final int NUMBER_COUNT = 6;

        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
    }
}
