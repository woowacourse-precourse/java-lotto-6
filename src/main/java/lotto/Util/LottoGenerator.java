package lotto.Util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.Constant.Constant;
import lotto.Domain.Lotto;

public class LottoGenerator {

    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Constant.LOTTO_MIN_NUMBER, Constant.LOTTO_MAX_NUMBER,
                Constant.LOTTO_LENGTH);
        Collections.sort(numbers);
        
        return new Lotto(numbers);
    }
}
