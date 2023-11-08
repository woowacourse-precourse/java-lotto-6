package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {
    }

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.START_NUMBER, LottoConstants.END_NUMBER,
                LottoConstants.LOTTO_NUMBER_SIZE);
    }
}
