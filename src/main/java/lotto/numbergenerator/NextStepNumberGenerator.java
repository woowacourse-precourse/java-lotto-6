package lotto.numbergenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NextStepNumberGenerator implements NumberGenerator {
    public List<Integer> generateNumbers(int startInclusive, int endInclusive, int size) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, size);
    }
}
