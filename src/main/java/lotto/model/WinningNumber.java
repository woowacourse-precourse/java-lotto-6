package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.view.ErrorMessage.*;

public class WinningNumber extends Number{
    private final List<Integer> winningNumbers;
    private static final int size = 6;

    public WinningNumber(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static void checkDuplicate(List<Integer> numbers) throws IllegalArgumentException{
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNumberLength(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != size) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
