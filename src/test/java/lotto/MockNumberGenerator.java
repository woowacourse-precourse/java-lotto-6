package lotto;

import java.util.List;
import lotto.generator.NumberGenerator;

public class MockNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> create() {
        return List.of(1, 3, 5, 7, 9, 11);
    }
}
