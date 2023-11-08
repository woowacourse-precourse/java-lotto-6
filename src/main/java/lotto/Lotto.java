package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        valid(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void valid(List<Integer> numbers) {
        TreeSet<Integer> numbersTreeSet = new TreeSet<>(numbers);
        ArrayList<Integer> numbersArrayList = new ArrayList<>(numbersTreeSet);
        if (numbersArrayList.size() != 6) {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public String toString() {
        numbers.sort(Comparator.naturalOrder());
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
