package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> create() {
        return ascendOrder(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    private List<Integer> ascendOrder(List<Integer> randomNumbers) {
        return randomNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
