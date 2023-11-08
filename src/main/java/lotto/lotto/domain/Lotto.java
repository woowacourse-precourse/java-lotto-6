package lotto.lotto.domain;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.numbers.sort(Comparator.comparingInt(a -> a));
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void printNumbers() {
        System.out.print("[" + numbers.get(0).toString());
        for (int i = 1; i < this.numbers.size(); i++) {
            System.out.print(", " + numbers.get(i).toString());
        }
        System.out.println("]");
    }

}
