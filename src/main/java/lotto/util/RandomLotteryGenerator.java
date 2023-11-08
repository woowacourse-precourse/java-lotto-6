package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLotteryGenerator implements RandomNumberGenerator {

    @Override
    public List<Integer> generateRandomLotteries() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
