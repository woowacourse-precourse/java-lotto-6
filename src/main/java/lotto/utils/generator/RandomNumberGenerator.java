package lotto.utils.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.Constant;
import lotto.domain.lotto.Lotto;

public class RandomNumberGenerator implements RandomNumber {

    private List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                Constant.ALLOWED_MINIMUM_LOTTO_NUMBER,
                Constant.ALLOWED_MAXIMUM_LOTTO_NUMBER,
                Constant.ALLOWED_LOTTO_SIZE
        );
    }

    public Lotto generateLotto() {
        return new Lotto(generate());
    }
}
