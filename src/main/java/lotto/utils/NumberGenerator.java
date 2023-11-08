package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class NumberGenerator {
    public static List<Integer> generateNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
