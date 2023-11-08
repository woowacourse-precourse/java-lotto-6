package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.Lotto;

public class RandomLottoGenerator {

    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_MIN_NUMBER, Constants.LOTTO_MAX_NUMBER, Constants.LOTTO_NUMBER_LENGTH);
        return new Lotto(numbers);
    }
}
