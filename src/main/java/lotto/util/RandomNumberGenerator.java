package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoNo;

public class RandomNumberGenerator {
    public static List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoNo.MIN_NO, LottoNo.MAX_NO, Lotto.LOTTO_SIZE);
    }
}
