package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.lotto.Lotto;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_MIN, Lotto.LOTTO_MAX,
                Lotto.LOTTO_SIZE);
        return new Lotto(numbers);
    }
}
