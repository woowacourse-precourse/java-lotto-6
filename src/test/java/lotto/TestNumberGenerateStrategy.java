package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.model.NumberGenerateStrategy;

public class TestNumberGenerateStrategy implements NumberGenerateStrategy {

    @Override
    public List<Integer> generate() {
        return Arrays.asList(44, 28, 10, 45, 30, 12);
    }
}
