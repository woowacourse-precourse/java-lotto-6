package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.view.ErrorMessage.*;

public class WinningNumber extends Number{
    private final List<Integer> winningNumbers;
    private static final int size = 6;

    public WinningNumber(List<Integer> winningNumbers) {
        checkNumberLength(winningNumbers);
        checkRangeRotate(winningNumbers);
        checkDuplicate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void checkRangeRotate(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            checkRange(number);
        }
    }

    private void checkDuplicate(List<Integer> numbers) throws IllegalArgumentException{
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            duplicatedWinningNumbers();
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberLength(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != size) {
            notEnoughLengthOfWinningNumbersExceptionMessage();
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
