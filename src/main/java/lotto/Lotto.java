package lotto;

import java.util.*;

import static lotto.Constants.LOTTERY_DIGIT_LENGTH;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTERY_DIGIT_LENGTH) {
            throw new IllegalArgumentException();
        }

        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() < numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public Prize check(WinningNumbers winningNumbers) {
        int count = 0;

        for (int number : winningNumbers.getNumbers()) {
            if (numbers.contains(number)) {
                count++;
            }
        }
        if (count == 6) {
            return Prize.First;
        }
        if (count == 5) {
            if (numbers.contains(winningNumbers.getBonus())) {
                return Prize.Second;
            }
            return Prize.Third;
        }
        if (count == 4) {
            return Prize.Forth;
        }
        if (count == 3) {
            return Prize.Fifth;
        }
        return Prize.None;
    }

    @Override
    public String toString() {
        return numbers.toString();

    }
}
