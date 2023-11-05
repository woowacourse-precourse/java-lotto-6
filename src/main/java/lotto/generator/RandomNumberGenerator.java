package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    private final int min = 1;
    private final int max = 45;

    @Override
    public List<Integer> generate(int size) {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(min, max, size);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}
