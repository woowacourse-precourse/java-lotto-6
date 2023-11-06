package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoGenerator {
    public static List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoNo.MIN_NO, LottoNo.MAX_NO, Lotto.LOTTO_SIZE);
    }
}
