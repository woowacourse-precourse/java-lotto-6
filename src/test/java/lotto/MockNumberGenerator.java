package lotto;

import java.util.List;
import lotto.generator.NumberGenerator;

public class MockNumberGenerator implements NumberGenerator {
    private final List<Integer> numbers;

    public MockNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> create() {
        return numbers;
    }
}
