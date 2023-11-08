package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class randomNumbersLotto {
    public List<Integer> makeRandomNumLottos() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
