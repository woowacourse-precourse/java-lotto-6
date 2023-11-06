package lotto;

import java.util.List;
import lotto.model.NumberGenerateStrategy;

public class TestNumberGenerateStrategy implements NumberGenerateStrategy {

    @Override
    public List<Integer> generate() {
        return List.of(44, 10, 30, 12, 28, 45);
    }
}
