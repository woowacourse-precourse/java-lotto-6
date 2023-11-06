package lotto.domain;

import java.util.List;

import static lotto.util.Parser.stringToInt;
import static lotto.util.Parser.stringToList;

public class WinningNumbers {
    List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validate(List<Integer> winningNumbers) {
        validateNumberBoundary(winningNumbers);
    }

    private void validateNumberBoundary(List<Integer> winningNumbers) {
        for(int num : winningNumbers) {
            if(num<1 || num>45)
                throw new IllegalArgumentException();
        }
    }
}
