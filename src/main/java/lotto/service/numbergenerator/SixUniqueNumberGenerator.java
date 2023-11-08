package lotto.service.numbergenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class SixUniqueNumberGenerator implements NumberGenerator {

    private static int START_INCLUSIVE = 1;
    private static int END_ENCLUSIVE = 45;
    private static int COUNT = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_ENCLUSIVE, COUNT);
    }
}
