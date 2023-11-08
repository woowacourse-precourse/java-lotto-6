package lotto.manager.mock;

import lotto.domain.NumberGenerator;

import java.util.List;

public class MockNumberGenerator implements NumberGenerator<List<Integer>> {
    @Override
    public List<Integer> generate() {
        return List.of(1, 2, 3, 4, 5, 6);
    }
}
