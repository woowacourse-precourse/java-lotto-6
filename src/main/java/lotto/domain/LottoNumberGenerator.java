package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class LottoNumberGenerator {
    private static final int LOTTO_LENGTH = 6;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    public static List<Integer> generateLottoNumber() {
        return pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, LOTTO_LENGTH);
    }
}
