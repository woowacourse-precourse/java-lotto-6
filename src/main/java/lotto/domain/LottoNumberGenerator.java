package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        // Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
}
