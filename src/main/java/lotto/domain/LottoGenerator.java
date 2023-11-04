package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constants.LottoConstants;

public class LottoGenerator implements Generator {

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_NUMBER.getConstants(),
                LottoConstants.MAX_NUMBER.getConstants(), LottoConstants.LENGTH.getConstants());
        return numbers;
    }
}
