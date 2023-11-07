package lotto.model.trade;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.lotto.Lotto;

public class AutoLottoGenerator implements LottoGenerator {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final AutoLottoGenerator instance = new AutoLottoGenerator();

    private AutoLottoGenerator() {
    }

    public static AutoLottoGenerator getInstance() {
        return instance;
    }

    public Lotto generate() {
        List<Integer> lottoNumbers = pickUniqueRandomNumbers();
        return new Lotto(lottoNumbers);
    }

    private List<Integer> pickUniqueRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                MINIMUM_LOTTO_NUMBER,
                MAXIMUM_LOTTO_NUMBER,
                LOTTO_SIZE
        );
    }
}
