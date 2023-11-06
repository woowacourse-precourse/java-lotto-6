package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public void matchNumbers(List<List<Integer>> ticketNumbers) {
        for (List<Integer> ticket : ticketNumbers) {
            Set<Integer> matchedNumbers = new HashSet<>(ticket);
            matchedNumbers.retainAll(numbers);

            int matchedNumberCount = matchedNumbers.size();
            System.out.println(matchedNumberCount);
        }
    }
}
