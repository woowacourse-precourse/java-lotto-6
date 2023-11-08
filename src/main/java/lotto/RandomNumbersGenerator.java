package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumbersGenerator {
    static final int LOTTO_RANGE_MAX = 1;
    static final int LOTTO_RANGE_MIN = 45;
    static final int LOTTO_NUMBER_SIZE = 6;

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_MAX, LOTTO_RANGE_MIN, LOTTO_NUMBER_SIZE);
    }
}
