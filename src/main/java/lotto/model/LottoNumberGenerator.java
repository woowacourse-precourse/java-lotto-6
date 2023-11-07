package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {

    private static final LottoNumberGenerator instance = new LottoNumberGenerator();

    private LottoNumberGenerator() {
    }

    public static LottoNumberGenerator getInstance() {
        return instance;
    }

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
