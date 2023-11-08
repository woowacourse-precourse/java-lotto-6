package lotto.utils.generator;

import java.util.Collections;
import java.util.List;
import lotto.utils.generator.NumberGenerator;

public class MockNumberGenerator implements NumberGenerator {


    private final List<Integer> numbers;

    public MockNumberGenerator(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generate() {
        return Collections.unmodifiableList(numbers);
    }
}
