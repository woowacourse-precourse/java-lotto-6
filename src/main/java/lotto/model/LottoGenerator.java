package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {

    private static final LottoGenerator instance = new LottoGenerator();

    private LottoGenerator() {
    }

    public static LottoGenerator getInstance() {
        return instance;
    }

    public Lotto generate() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers);
    }

}
