package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static ArrayList<List<Integer>> randomNumbers = new ArrayList<List<Integer>>();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> sortNumber(List<Integer> unSortedNumbers) {
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

}
