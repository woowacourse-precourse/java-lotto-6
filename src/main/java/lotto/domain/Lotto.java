package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = ascendingSort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkNumbersCount(numbers);
        checkDuplicateNumbers(numbers);
    }

    private void checkNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 6개가 아닙니다.");
        }
    }

    private void checkDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> removeDuplicateNumbers = new HashSet<>(numbers);
        if (removeDuplicateNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또에서 중복되는 번호가 있습니다");
        }
    }

    private List<Integer> ascendingSort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public int matchCount(Lotto other) {
        Set<Integer> matchNumbers = new HashSet<>(this.numbers);
        matchNumbers.retainAll(other.numbers);
        return matchNumbers.size();
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(this.numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
