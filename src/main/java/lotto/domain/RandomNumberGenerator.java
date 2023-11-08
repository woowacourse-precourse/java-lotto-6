package lotto.domain;

import static lotto.domain.constant.LottoConstant.LOTTO_NUMBERS_COUNT;
import static lotto.domain.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.domain.constant.LottoConstant.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBERS_COUNT);
    }
}
