package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Generator {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 45;
    private static final int RANDOM_NUMBER_AMOUNT = 6;

    public static List<Integer> generateRandomNumber(){
        return Randoms.pickUniqueNumbersInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER, RANDOM_NUMBER_AMOUNT);
    }
}
