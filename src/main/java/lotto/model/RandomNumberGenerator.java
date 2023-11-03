package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.START_NUMBER, LottoConstants.END_NUMBER,
                LottoConstants.LOTTO_SIZE);
    }
}
