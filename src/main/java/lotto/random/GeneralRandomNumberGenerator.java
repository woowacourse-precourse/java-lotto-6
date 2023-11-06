package lotto.random;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstraint;
import java.util.List;

public class GeneralRandomNumberGenerator implements RandomNumberGenerator {
    @Override
    public List<Integer> pickUniqueNumbersInRange(int min, int max, int count) {
        return Randoms.pickUniqueNumbersInRange(min, max, count);
    }
}