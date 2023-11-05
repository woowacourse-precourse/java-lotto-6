package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    // 에러 발생
    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (!isWinningNumbersValid(winningNumbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isWinningNumbersValid(List<Integer> winningNumbers) {
        boolean duplicatesValid = checkForDuplicates(winningNumbers);
        boolean sizeValid = checkInputSizeIs6(winningNumbers);
        boolean boundsValid = checkInputBounds(winningNumbers);
        return duplicatesValid && sizeValid && boundsValid;
    }

    private boolean checkForDuplicates(List<Integer> winningNumbers) {
        Set<Integer> numbers = new HashSet<>(winningNumbers);
        return numbers.size() == winningNumbers.size();
    }

    private boolean checkInputSizeIs6(List<Integer> winningNumbers) {
        return winningNumbers.size() == 6;
    }

    private boolean checkInputBounds(List<Integer> winningNumbers) {
        for (int number: winningNumbers) {
            if (!(1 <= number && number <= 45)){
                return false;
            }
        }
        return true;
    }


}
