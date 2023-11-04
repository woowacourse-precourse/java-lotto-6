package lotto.util;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;
import lotto.domain.Lotto;

public class RandomNumberGenerator {
    public static int START_INCLUSIVE_NUMBER = 1;
    public static int END_INCLUSIVE_NUMBER = 45;

    public static List<Integer> generate() {
        return pickUniqueNumbersInRange(START_INCLUSIVE_NUMBER, END_INCLUSIVE_NUMBER,
                Lotto.SIZE);
    }
}
