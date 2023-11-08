package lotto.model;

import static lotto.constants.LottoConstants.LOTTO_END;
import static lotto.constants.LottoConstants.LOTTO_SIZE;
import static lotto.constants.LottoConstants.LOTTO_START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoFactory {

    public static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START, LOTTO_END,
                LOTTO_SIZE);
        return new Lotto(numbers);
    }
}
