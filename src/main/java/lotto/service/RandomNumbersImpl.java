package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class RandomNumbersImpl implements RandomNumbers {
    private final int NUM_START = 1;
    private final int NUM_END = 45;
    private final int NUM_COUNT = 6;

    @Override
    public List<Integer> generate() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(NUM_START, NUM_END, NUM_COUNT);
        try {
            Collections.sort(randomNumbers);
            return randomNumbers;
        } catch (UnsupportedOperationException e) {
            return randomNumbers;
        }
    }
}
