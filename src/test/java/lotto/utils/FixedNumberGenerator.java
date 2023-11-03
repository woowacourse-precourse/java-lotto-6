package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class FixedNumberGenerator implements NumberGenerator{
    private final List<Integer> numbers;

    public FixedNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generateNumbers() {
        return new ArrayList<>(numbers);
    }

}
