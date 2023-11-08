package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RandomUtil {
    public List<Integer> createSortedRandomNumbersInRange(int min, int max, int size) {
        return Randoms.pickUniqueNumbersInRange(min, max, size).stream().sorted().collect(Collectors.toList());
    }
}