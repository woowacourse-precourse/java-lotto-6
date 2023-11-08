package lotto.Util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Constant.Constant;
import lotto.Domain.Lotto;

public class LottoGenerator {

    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Constant.LOTTO_MIN_NUMBER, Constant.LOTTO_MAX_NUMBER,
                Constant.LOTTO_LENGTH);

        return new Lotto(numbers);
    }
}
