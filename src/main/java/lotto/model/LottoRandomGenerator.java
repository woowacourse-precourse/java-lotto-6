package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.LottoConstants;

public class LottoRandomGenerator implements LottoGenerator {
    @Override
    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoConstants.LOTTO_NUMBER_MIN,
                LottoConstants.LOTTO_NUMBER_MAX,
                LottoConstants.SIZE_OF_LOTTO_TICKET);
        return new Lotto(numbers);
    }
}
