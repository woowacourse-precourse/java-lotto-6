package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sorted(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validate_number(List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDuplicate(final List<Integer> numbers) {
        long distinctcount = numbers.stream()
                .distinct()
                .count();
        return distinctcount < numbers.size();
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
    public int getMatchLottoNumber(Winner winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::isContain)
                .count();
    }

    public String toString() {
        return numbers.toString();
    }
}
