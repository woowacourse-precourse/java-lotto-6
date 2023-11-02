package util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

class NumberGenerator {
    private NumberGenerator() {
    }

    static Lotto generateNumbers()
    {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
        return new Lotto(numbers);
    }
}
