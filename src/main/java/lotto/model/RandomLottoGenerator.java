package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_LOWER_INCLUSIVE, Lotto.LOTTO_UPPER_INCLUSIVE,
                Lotto.LOTTO_SIZE);
        return new Lotto(numbers);
    }
}
