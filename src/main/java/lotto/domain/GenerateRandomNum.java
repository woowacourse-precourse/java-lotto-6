package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static lotto.utils.Constants.MIN_NUMBER_IN_RANGE;
import static lotto.utils.Constants.MAX_NUMBER_IN_RANGE;
import static lotto.utils.ErrorMessages.CHECK_NUMBER_IN_RANGE;

public class GenerateRandomNum {

    public static int pickNumber() {
        int num = Randoms.pickNumberInRange(MIN_NUMBER_IN_RANGE, MAX_NUMBER_IN_RANGE);
        checkNumberInRange(num);
        return num;
    }

    public static void checkNumberInRange(int num) {
        if (num < MIN_NUMBER_IN_RANGE || num > MAX_NUMBER_IN_RANGE)
            throw new IllegalArgumentException(CHECK_NUMBER_IN_RANGE);
    }
}
