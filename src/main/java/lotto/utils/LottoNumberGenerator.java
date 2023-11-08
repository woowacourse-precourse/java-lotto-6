package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.TotalLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;
    private final TotalLotto totalLotto;

    public LottoNumberGenerator(int lottoPrice) {
        this.totalLotto = generateLotto(lottoPrice);
    }

    private TotalLotto generateLotto(int generateLottoNumber) {
        TotalLotto totalLotto = new TotalLotto();
        for (int i = 0; i < generateLottoNumber; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_LENGTH);
            Lotto lotto = new Lotto(numbers);
            totalLotto.generateTotalLotto(lotto);
        }
        return totalLotto;
    }

    public TotalLotto getTotalLotto() {
        return totalLotto;
    }
}
