package lotto.lotto.domain;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.numbers.sort(Comparator.comparingInt(a -> a));
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] numbers size must be 6");
        }
        validateUnique(numbers);
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] number must be unique");
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
