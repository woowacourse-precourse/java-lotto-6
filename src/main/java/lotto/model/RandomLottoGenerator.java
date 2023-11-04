package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {
    private static final int LOTTO_LOWER_INCLUSIVE = 1;
    private static final int LOTTO_UPPER_INCLUSIVE = 45;
    private static final int LOTTO_SIZE = 6;

    @Override
    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_LOWER_INCLUSIVE, LOTTO_UPPER_INCLUSIVE,
                LOTTO_SIZE);
        return new Lotto(numbers);
    }
}
