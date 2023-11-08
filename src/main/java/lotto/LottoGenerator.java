package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int SIZE = 6;

    public static List<Integer> generateRandomLotto() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, SIZE));
    }
}
