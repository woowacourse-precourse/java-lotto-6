package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
