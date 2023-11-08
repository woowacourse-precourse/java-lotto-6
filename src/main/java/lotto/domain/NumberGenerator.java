package lotto.domain;

import java.util.List;

public interface NumberGenerator {
    List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count);
}
