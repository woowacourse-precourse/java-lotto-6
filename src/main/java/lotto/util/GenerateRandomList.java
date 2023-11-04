package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class GenerateRandomList {
    private final static Integer MIN_NUMBER = 1;
    private final static Integer MAX_NUMBER = 45;
    private final static Integer NUMBER_SIZE = 6;

    private GenerateRandomList() {
    }

    public static List<Integer> createRandomList() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_SIZE);
        Collections.sort(numbers);
        return numbers;
    }
}
