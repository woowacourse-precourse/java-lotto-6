package lotto.model;

import java.util.List;
import lotto.view.message.Error;

public class WinningNumber {

    private List<Integer> winningNumbers;

    private WinningNumber(String winningNumbers) {
        List<String> seperatedNumbers = split(winningNumbers);
        checkOversize(seperatedNumbers);
    }

    public static WinningNumber create(String winningNumbers) {
        return new WinningNumber(winningNumbers);
    }

    private List<String> split(String winningNumbers) {
        return List.of(winningNumbers.split(","));
    }

    private void checkOversize(List<String> seperatedNumbers) {
        if (seperatedNumbers.size() != Lotto.NUMBER_COUNT) {
            throw new IllegalArgumentException(Error.WINNING_NUMBER_OVERSIZE.getMessage());
        }
    }
}
