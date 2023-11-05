package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbers implements LottoMaker {
    @Override
    public List<Integer> genrate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
