package lotto.random;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstraint;
import java.util.List;

public class GeneralRandomNumberGenerator implements RandomNumberGenerator {
    @Override
    public List<Integer> pickUniqueNumbersInRange(int min, int max) {
        return Randoms.pickUniqueNumbersInRange(min, max, LottoConstraint.LOTTO_NUMBER_COUNT.getValue());
    }
}