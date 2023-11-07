package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class GetRandomNumber {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
