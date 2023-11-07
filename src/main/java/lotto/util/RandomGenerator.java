package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public final class RandomGenerator {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    public static List<Integer> getAutoNumbers(int count){
        return Randoms.pickUniqueNumbersInRange(START_NUMBER,END_NUMBER,count);
    }
}
