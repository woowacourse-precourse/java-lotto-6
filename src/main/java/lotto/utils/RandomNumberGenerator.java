package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.LottoConstraint;

public class RandomNumberGenerator {

    public static List<Integer> generateUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstraint.MIN.getConstraint(),
                LottoConstraint.MAX.getConstraint(), LottoConstraint.SIZE.getConstraint());
    }
}
