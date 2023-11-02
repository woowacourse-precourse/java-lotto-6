package lotto.util;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoGenerator {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT = 6;

    public List<Integer> generateLotto() {
        return pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT);
    }
}
