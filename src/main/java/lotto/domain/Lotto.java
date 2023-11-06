package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto copyOf(Lotto lotto) {
        return new Lotto(lotto.getNumbers());
    }

    public static Lotto createLotto(LottoRandom random) {
        return new Lotto(random.generateNumbers());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int number : numbers) {
            uniqueNumbers.add(number);
        }

        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int matches(List<Integer> otherNumbers) {
        return (int) numbers.stream()
                .filter(otherNumbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
