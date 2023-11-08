package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    private static final ArrayList<List<Integer>> randomNumbers = new ArrayList<List<Integer>>();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public List<Integer> sortNumber(List<Integer> numbers) {
        List<Integer> unSortedNumbers = new ArrayList<>(numbers);
        Collections.sort(unSortedNumbers);
        return unSortedNumbers;
    }

    public ArrayList<List<Integer>> makeRandoms(List<Integer> numbers) {
        System.out.println(sortNumber(numbers));
        randomNumbers.add(numbers);
        return randomNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicate(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException();

        }
    }
}
