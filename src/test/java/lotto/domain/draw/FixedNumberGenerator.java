package lotto.domain.draw;

import java.util.List;
import lotto.domain.lotto.NumbersGenerator;

public class FixedNumberGenerator implements NumbersGenerator {
    private final List<Integer> numbers;

    public FixedNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generate() {
        return numbers;
    }
}
