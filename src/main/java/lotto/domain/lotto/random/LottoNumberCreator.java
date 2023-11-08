package lotto.domain.lotto.random;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;

import java.util.List;

public class LottoNumberCreator {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;

    public Lotto createLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE);
        return new Lotto(randomNumbers.stream().sorted().toList());
    }
}
