package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constant.LottoConstant.LOTTO_LENGTH;
import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;

import java.util.List;

public class LottoNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumber() {
        return pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_LENGTH);
    }
}
