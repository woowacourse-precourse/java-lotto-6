package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public final class RandomGeneratorImpl implements RandomGenerator{

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int COUNT = 6;

    @Override
    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
    }
}
