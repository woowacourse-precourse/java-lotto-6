package lotto.domain;

import lotto.util.Validator;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate(numbers);
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        Validator.checkIfWinningNumbersAreSix(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        Validator.checkIfNoDuplicateInWinningNumbers(numbers);
    }

    public int compare(Lotto other) {
        Set<Integer> numberSetOfOther = new HashSet<>(other.numbers);
        int numOfMatches = 0;
        for (Integer number : this.numbers) {
            numOfMatches += getOneIfMatches(numberSetOfOther.contains(number));
        }
        return numOfMatches;
    }

    private int getOneIfMatches(boolean matches) {
        if (matches) {
            return 1;
        }
        return 0;
    }

    public boolean contains(Integer number) {
        return this.numbers.contains(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Lotto compareTarget)) {
            return false;
        }
        for (Integer number : this.numbers) {
            if (!compareTarget.contains(number)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.numbers.stream().reduce(0, Integer::sum);
    }

    @Override
    public String toString() {
        List<String> convertedToStrings = this.numbers.stream().map(String::valueOf).toList();
        String commaJoined = String.join(", ", convertedToStrings);
        return "[" + commaJoined + "]";
    }
}
