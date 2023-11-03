package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
    private static final int LOTTO_NUMBER_UPPER_BOUND = 45;

    private RandomNumberGenerator() {
    }

    public static int generateLottoNumber() {
        return Randoms.pickNumberInRange(
                LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND);
    }
}
