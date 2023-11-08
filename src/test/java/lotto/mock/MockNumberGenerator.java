package lotto.mock;

import java.util.List;
import lotto.domain.NumberGenerator;

public class MockNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate() {
        return List.of(1,2,3,4,5,6);
    }
}
