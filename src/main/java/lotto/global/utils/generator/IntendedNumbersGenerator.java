package lotto.global.utils.generator;

import java.util.List;

public class IntendedNumbersGenerator implements NumbersGenerator {

    private final List<Integer> numbers;

    public IntendedNumbersGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generate() {
        return numbers;
    }
}
