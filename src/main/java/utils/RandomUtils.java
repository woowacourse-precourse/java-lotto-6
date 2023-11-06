package utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomUtils {
    public static List<Integer> createSortedUniqueRandomListOf(int startInclusive, int endInclusive, int expectedSize) {
        List<Integer> ret = new ArrayList<>();
        while (ret.size() < expectedSize) {
            var random = Randoms.pickNumberInRange(startInclusive, endInclusive);
            if (ret.contains(random)) {
                continue;
            }
            ret.add(random);
        }
        ret.sort(Integer::compareTo);
        return ret;
    }
}
