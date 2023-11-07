package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

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

    public int matches(List<Integer> otherNumbers) {
        validate(otherNumbers);
        return (int) numbers.stream()
                .filter(otherNumbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNonNull(numbers);
        validateSize(numbers);
        validateUniqueNumbers(numbers);
        validateNumbersInRange(numbers);
    }

    private static void validateNonNull(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int number : numbers) {
            uniqueNumbers.add(number);
        }

        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException();
            }
        }
    }
}
