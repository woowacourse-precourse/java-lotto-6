package lotto.domain.number;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.constant.LottoConstant;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoConstant.MIN_NUMBER.getValue(),
                LottoConstant.MAX_NUMBER.getValue(), LottoConstant.SIZE.getValue());
    }
}
