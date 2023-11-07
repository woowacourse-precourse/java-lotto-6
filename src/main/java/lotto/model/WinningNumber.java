package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.view.ErrorMessage.*;

public class WinningNumber {
    private final List<Integer> winningNumbers;
    private static final int size = 6;

    public WinningNumber(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
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
