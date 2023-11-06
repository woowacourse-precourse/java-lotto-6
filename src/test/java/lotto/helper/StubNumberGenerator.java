package lotto.helper;

import java.util.List;
import lotto.model.NumberGenerator;

public class StubNumberGenerator implements NumberGenerator {

    private final List<Integer> numbers;

    public StubNumberGenerator(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generateSortedList() {
        return numbers;
    }
}
