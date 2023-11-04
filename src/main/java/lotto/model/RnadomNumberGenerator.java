package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RnadomNumberGenerator {
    public static List<Integer> generateUniqueSixNumber() {
        return Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.NUMBER_COUNT);
    }
}
