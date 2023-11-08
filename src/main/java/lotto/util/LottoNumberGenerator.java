package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {

    private LottoNumberGenerator() {
    }

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(Validator.LOTTO_NUMBER_MIN,
            Validator.LOTTO_NUMBER_MAX, Validator.LOTTO_SIZE);
    }


}
