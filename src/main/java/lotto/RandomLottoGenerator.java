package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class RandomLottoGenerator {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int SIZE = 6;
    public static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN, MAX, SIZE);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
