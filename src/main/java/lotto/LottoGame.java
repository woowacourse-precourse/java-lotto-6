package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGame {
    public static final int START_RANGE = 1;
    public static final int END_RANGE = 45;
    public static final int COUNT = 6;

    private List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, COUNT);
    }
}
