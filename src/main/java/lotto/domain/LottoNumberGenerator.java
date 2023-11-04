package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {

    private LottoNumberGenerator() {
    }

    public static List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
