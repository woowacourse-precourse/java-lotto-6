package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generate(int start, int end, int size) {
        return Randoms.pickUniqueNumbersInRange(start, end, size);
    }
}
