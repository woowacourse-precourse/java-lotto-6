package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LottoConstants.LOTTO_SIZE);
    }
}
