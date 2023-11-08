package lotto.helper;

import java.util.List;
import lotto.generator.NumberGenerator;

public class FixedNumberGenerator implements NumberGenerator {
    private List<List<Integer>> numbers;
    private int index = 0;
    private int counter = 0;

    public void setNumbers(List<List<Integer>> numbers) {
        this.numbers = numbers;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public List<Integer> generate(int start, int end, int size) {
        if (index == numbers.size()) {
            return numbers.get(index - 1);
        }

        counter++;

        return numbers.get(index++);
    }
}
