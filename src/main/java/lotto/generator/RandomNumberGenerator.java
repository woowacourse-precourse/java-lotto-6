package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberGenerator implements NumberGenerator {
    private final int min = 1;
    private final int max = 45;

    @Override
    public List<Integer> generate(int size) {
        return Randoms.pickUniqueNumbersInRange(min, max, size).stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
