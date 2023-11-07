package lotto.generator;

import java.util.List;

public class CustomIntegerListGenerator implements IntegerListGenerator {
    @Override
    public List<Integer> generateIntegerList() {
        return List.of(1, 2, 3, 4, 5, 6);
    }
}
