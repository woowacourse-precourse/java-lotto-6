package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.LottoInfo;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> pickNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoInfo.LOTTO_MIN_NUMBER.getValue(),
                LottoInfo.LOTTO_MAX_NUMBER.getValue(), LottoInfo.LOTTO_SIZE.getValue());

        return numbers;
    }
}
