package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import lotto.policy.LottoPolicy;

public class LottoProvider {

    public static Lotto createLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
            LottoPolicy.MIN_LOTTO_NUMBER.getValue(),
            LottoPolicy.MAX_LOTTO_NUMBER.getValue(),
            LottoPolicy.LOTTO_NUMBER_COUNT.getValue()
        ));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private LottoProvider() {
    }
}
