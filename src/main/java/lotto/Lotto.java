package lotto;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Comparator.comparingInt(o -> o));
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public boolean hasNum(int num) {
        return numbers.contains(num);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    // TODO: 추가 기능 구현
}
