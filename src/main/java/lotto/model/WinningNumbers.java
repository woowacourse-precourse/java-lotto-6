package lotto.model;

import java.util.List;
import lotto.validator.Validator;

public class WinningNumbers {
    private static List<Integer> winningNumbers;
    // 보너스 번호

    public WinningNumbers(List<Integer> winningNumbers) {
        Validator validator = new Validator();
        validator.validate(winningNumbers);
        WinningNumbers.winningNumbers = winningNumbers;
    }

    public static List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

}
