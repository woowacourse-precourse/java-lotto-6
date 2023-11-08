package lotto.domain.mock;

import lotto.domain.random.RandomNumberRangePicker;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MockNumberPicker implements RandomNumberRangePicker {

    private final Queue<List<Integer>> numbers;

    private MockNumberPicker(Queue<List<Integer>> numbers) {
        this.numbers = numbers;
    }

    @SafeVarargs
    public static MockNumberPicker setNumbers(List<Integer>... numbers) {
        Queue<List<Integer>> queue = new LinkedList<>(Arrays.asList(numbers));
        return new MockNumberPicker(queue);
    }

    @Override
    public List<Integer> pickNumbers() {
        if (!numbers.isEmpty()) {
            return numbers.remove();
        }
        throw new IllegalArgumentException("더이상 존재하지 않음.");
    }
}
