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
                LottoConstants.THE_SIZE_OF_ONE_LOTTO);
        return new Lotto(numbers);
    }
}
