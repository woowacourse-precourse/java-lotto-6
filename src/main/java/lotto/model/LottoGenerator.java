package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER,
                Constants.MAX_LOTTO_NUMBER,
                Constants.LOTTO_NUMBER_COUNT).stream().sorted().toList();
    }
}
