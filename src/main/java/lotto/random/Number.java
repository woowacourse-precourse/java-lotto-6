package lotto.random;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Number {

    public static List<Integer> LottoGenerator() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
