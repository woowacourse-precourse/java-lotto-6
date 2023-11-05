package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public final class NumberGenerator {
    public static List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
