package lotto.Input;

import lotto.Lotto;

import java.util.Comparator;
import java.util.List;

public class LottoGenerator {
    public static Lotto createRandomLotto() throws IllegalArgumentException {
        List<Integer> numbers = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return new Lotto(numbers);
    }
}
