package lotto.entity;

import lotto.common.Range;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Range.SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public int checkWin(Lotto prize, int bonus) {
        return getRank(getCount(prize), bonus);
    }

    private int getCount(Lotto prize) {
        int count = 0;

        for (int number : numbers) {
            if (prize.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    private int getRank(int count, int bonus) {
        if (count == Range.SIZE.getValue()) {
            return 1;
        }
        if (count == (Range.SIZE.getValue() - 1) && numbers.contains(bonus)) {
            return 2;
        }
        if (count >= 3) {
            return (Range.SIZE.getValue() + 2) - count;
        }
        return 0;
    }

    private void checkNumbers(List<Integer> numbers) {
        Set<Integer> check = new HashSet<>();

        for (int number : numbers) {
            if (!check.add(checkRange(number))) {
                throw new IllegalArgumentException();
            }
        }
    }

    private int checkRange(int number) {
        if (number < Range.START.getValue() || number > Range.END.getValue()) {
            throw new IllegalArgumentException();
        }
        return number;
    }

}
