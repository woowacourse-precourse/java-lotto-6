package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.WinningCase;

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

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException();
            }
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    public WinningCase confirmWin(int[] winningNumbers, int bonusNumber) {
        int count = 0;

        for (int winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                count += 1;
            }
        }

        if (count == 3) {
            return WinningCase.FIFTH;
        }
        if (count == 4) {
            return WinningCase.FOURTH;
        }
        if (count == 6) {
            return WinningCase.FIRST;
        }
        if (numbers.contains(bonusNumber)) {
            return WinningCase.SECOND;
        }
        if (count == 5) {
            return WinningCase.THIRD;
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");
        numbers.forEach(number -> sb.append(number).append(", "));
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        return sb.toString();
    }
}
