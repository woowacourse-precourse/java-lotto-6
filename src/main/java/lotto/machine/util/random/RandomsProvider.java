package lotto.machine.util.random;

import java.util.List;

public interface RandomsProvider {
    List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count);
}
