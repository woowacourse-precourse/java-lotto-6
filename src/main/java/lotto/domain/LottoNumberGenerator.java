package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                LottoNumberRule.MIN.number(),
                LottoNumberRule.MAX.number(),
                LottoNumberRule.COUNT.number()
        );
    }
}
