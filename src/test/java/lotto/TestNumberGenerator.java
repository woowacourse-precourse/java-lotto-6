package lotto;

import java.util.List;
import lotto.model.NumberGenerator;

public class TestNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate() {
        return List.of(4, 9, 10, 12, 30, 44);
    }
}
