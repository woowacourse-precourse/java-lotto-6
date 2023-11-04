package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public final class LottoRandomNumbers {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int RANDOM_COUNT = 6;

    private LottoRandomNumbers() {
    }

    public static List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, RANDOM_COUNT);
    }
}
