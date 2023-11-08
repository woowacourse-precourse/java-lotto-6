package lotto.domain;

import java.util.List;

public interface RandomService {

    List<Integer> pickUniqueNumbersInRange(final int startInclusive, final int endInclusive, final int count);
}
