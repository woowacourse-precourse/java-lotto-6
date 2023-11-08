package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.config.Config;

public class RandomUtil {
    public static List<Integer> getRandomUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(Config.MIN_LOTTO, Config.MAX_LOTTO, Config.COUNT_LOTTO);
    }
}
