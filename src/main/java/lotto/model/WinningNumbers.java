package lotto.model;

import java.util.List;
import lotto.validator.ValidatorForModel;

public class WinningNumbers {
    private static List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        ValidatorForModel validator = new ValidatorForModel();
        validator.validate(winningNumbers);
        WinningNumbers.winningNumbers = winningNumbers;
    }

    public static List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public static WinningNumbers createForTesting(List<Integer> numbers) {
        return new WinningNumbers(numbers);
    }
}