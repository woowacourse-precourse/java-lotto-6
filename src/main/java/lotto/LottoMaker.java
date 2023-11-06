package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoMaker {
    public static List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        Collections.sort(numbers);

        return numbers;
    }
}
