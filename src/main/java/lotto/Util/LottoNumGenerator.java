package lotto.Util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumGenerator {
    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
