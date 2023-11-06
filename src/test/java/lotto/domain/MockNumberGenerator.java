package lotto.domain;

import java.util.List;

public class MockNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
        return List.of(1, 10, 32, 40, 17, 25);
    }
}
