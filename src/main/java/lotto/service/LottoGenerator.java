package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class LottoGenerator {
    private static final int LOTTO_SIZE = 6;

    public static Lotto generateAutoLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_SIZE));
    }
    public static Lotto generateNonAutoLotto(Integer... lottoNums) {
        return null;
    }
}
