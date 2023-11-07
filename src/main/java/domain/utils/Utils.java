package domain.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Utils {

    public static List<Integer> generateRandomNumbers(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }

}
