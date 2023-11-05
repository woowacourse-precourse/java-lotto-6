package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        String string = sortedNumbers.toString();
        return string;
    }

    public int getMatches(List<Integer> winningNumber) {
        int matches = compareWithWinningNumber(winningNumber);

        return matches;
    }


    private int compareWithWinningNumber(List<Integer> winningNumber) {
        int matches = 0;
        for (int i = 0; i < winningNumber.size(); i++) {
            int target = winningNumber.get(i);
            if (numbers.contains(target)) {
                matches++;
            }
            if (i < 6 && matches == 6) {
                matches++;
            }
        }
        return matches;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        validateDuplicated(numbers);
    }

    private void validateDuplicated(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

}
