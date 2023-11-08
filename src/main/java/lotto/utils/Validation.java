package lotto.utils;

import java.util.List;

public interface Validation {
    boolean isValidWinningNumbers(String input);
    boolean isValidBonusNumber(String input, List<Integer> winningNumbers);
    boolean isValidMoney(String input);
}
