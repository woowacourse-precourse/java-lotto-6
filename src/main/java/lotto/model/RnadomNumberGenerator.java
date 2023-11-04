package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RnadomNumberGenerator {
    public static List<Integer> generateUniqueSixNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
