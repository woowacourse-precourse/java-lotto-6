package lotto.util;

import static lotto.LottoConstance.LOTTO_SIZE;
import static lotto.LottoConstance.MAX_NUMBER_LOTTO_RANGE;
import static lotto.LottoConstance.MIN_NUMBER_LOTTO_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class LottoGenerator {
    public static Lotto generate() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER_LOTTO_RANGE.get(), MAX_NUMBER_LOTTO_RANGE.get(),
                LOTTO_SIZE.get()));
    }
}
