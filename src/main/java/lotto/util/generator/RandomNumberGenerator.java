package lotto.util.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generate(int min, int max, int length) {
        return Randoms.pickUniqueNumbersInRange(min, max, length);
    }
}
