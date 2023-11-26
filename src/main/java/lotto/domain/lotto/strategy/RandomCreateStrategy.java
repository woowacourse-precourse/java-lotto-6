package lotto.domain.lotto.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.Constant;
import lotto.domain.lotto.Lotto;

public class RandomCreateStrategy implements CreateStrategy {

    private List<Integer> create() {
        return Randoms.pickUniqueNumbersInRange(
                Constant.ALLOWED_MINIMUM_NUMBER.getConstant(),
                Constant.ALLOWED_MAXIMUM_NUMBER.getConstant(),
                Constant.ALLOWED_SIZE_PER_LOTTO.getConstant()
        );
    }

    public Lotto createLotto() {
        return new Lotto(create());
    }
}
