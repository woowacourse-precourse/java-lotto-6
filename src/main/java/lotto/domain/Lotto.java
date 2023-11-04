package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplication(numbers);
        this.numbers = duplicateSortedList(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> duplicateSortedList(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>(numbers);
        Collections.sort(list);
        return list;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
