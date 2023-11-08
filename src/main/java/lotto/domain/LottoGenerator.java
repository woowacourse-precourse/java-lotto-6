package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constants;

import java.util.List;

public class LottoGenerator {
    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_MIN_BOUND.getValue(),
                Constants.LOTTO_MAX_BOUND.getValue(),
                Constants.LOTTO_SIZE.getValue());
        return new Lotto(numbers);
    }
}