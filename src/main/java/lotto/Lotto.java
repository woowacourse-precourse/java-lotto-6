package lotto;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public String toString() {
        List<Integer> tmp = numbers.stream().sorted().toList();
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < tmp.size(); i++) {
            sb.append(tmp.get(i));
            if (i != tmp.size() - 1) {
                sb.append(", ");
            }
        }
        return new String(sb + "]");
    }
}
