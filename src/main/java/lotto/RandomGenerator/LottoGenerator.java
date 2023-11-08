package lotto.RandomGenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    public List<Integer> getLottoNumber() {
        List<Integer> selectedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return selectedNumbers;
    }
}
