package lotto.util;

import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class RandomNumbers {

    public static List<Integer> generateRandomNumbers() {
        return pickUniqueNumbersInRange(1, 45, 6);
    }
}
