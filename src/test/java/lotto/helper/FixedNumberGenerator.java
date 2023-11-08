package lotto.helper;

import java.util.List;
import lotto.generator.NumberGenerator;

public class FixedNumberGenerator implements NumberGenerator {
    private final List<List<Integer>> numbers;

    public FixedNumberGenerator(List<List<Integer>> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generate(int start, int end, int size) {
        return numbers.remove(0);
    }
}
