package lotto.model;

import java.util.List;
import lotto.util.validator.WinningNumbersValidator;

public class WinningNumber {

    private List<Integer> winningNumbers;

    public void inputWinningNumber(String input) {
        this.winningNumbers = WinningNumbersValidator.createValidator().validate(input);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
