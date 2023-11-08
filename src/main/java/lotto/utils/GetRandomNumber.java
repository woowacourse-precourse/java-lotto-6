package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GetRandomNumber {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int NUMBER_AMOUNT_LIMIT = 6;

    public static List<Integer> getRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, NUMBER_AMOUNT_LIMIT);
    }
}
