package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoNumberGenerator {
    public static final int LOTTO_LOWER_BOUND = 1;
    public static final int LOTTO_UPPER_BOUND = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private RandomLottoNumberGenerator(){

    }

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_LOWER_BOUND, LOTTO_UPPER_BOUND, LOTTO_NUMBER_SIZE);
    }

}
