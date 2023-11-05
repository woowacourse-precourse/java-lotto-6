package lotto.model;


import static lotto.util.validators.WinningNumbersValidator.validateWinningNumbers;

import java.util.List;
import lotto.util.Parser;


public class WinningNumbers {
    private final List<Integer> winning;

    public WinningNumbers(String winning) {
        validateWinningNumbers(winning);
        this.winning = Parser.parseString(winning).stream()
                .map(Integer::valueOf)
                .sorted()
                .toList();
    }

    public boolean contains(Integer number) {
        return winning.contains(number);
    }
}
