package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumber {
    public static List<Integer> make() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
