package lotto.model;

import java.util.Arrays;
import java.util.List;
import lotto.util.validator.WinningNumbersValidator;

public class WinningNumber {

    private List<Integer> winningNumbers;

    public void inputWinningNumber(String input) {
        WinningNumbersValidator.createValidator().validate(input);
        this.winningNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt).toList();;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
