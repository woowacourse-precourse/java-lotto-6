package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {

    private static final int COUNT_LOTTO_NUMBER = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT_LOTTO_NUMBER);
    }
}
