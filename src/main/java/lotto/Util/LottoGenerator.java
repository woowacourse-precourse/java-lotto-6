package lotto.Util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.Constant.Constant;
import lotto.Domain.Lotto;

public class LottoGenerator {

    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Constant.MIN_LOTTO_NUMBER,
                Constant.MAX_LOTTO_NUMBER,
                Constant.LOTTO_NUMBER_AMOUNT);
        Collections.sort(numbers);

        return new Lotto(numbers);
    }
}
