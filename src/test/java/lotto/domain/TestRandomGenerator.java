package lotto.domain;

import java.util.List;

public class TestRandomGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate() {
        return List.of(1, 2, 3, 4, 5, 6);
    }
}
