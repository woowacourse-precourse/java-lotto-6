package lotto;

import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

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
    public void printNumbers() {
        sort();
        StringJoiner stringJoiner = new StringJoiner(", ");
        numbers.forEach(number -> stringJoiner.add(number + ""));
        System.out.println("[" + stringJoiner + "]");
    }

    private void sort() {
        numbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }
}
