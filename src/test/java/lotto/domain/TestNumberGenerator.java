package lotto.domain;

import java.util.List;
import lotto.service.NumberGenerator;

public class TestNumberGenerator implements NumberGenerator {

    private final List<List<Integer>> numbers;
    private int index;

    public TestNumberGenerator(List<List<Integer>> numbers) {
        this.numbers = numbers;
        this.index = 0;
    }

    @Override
    public List<Integer> generate() {
        return numbers.get(index++);
    }
}
