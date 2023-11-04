package lotto.util.wrapper;


import static lotto.util.validators.WinningBonusNumbersValidator.validateWinningNumber;

import java.util.List;
import lotto.util.Parser;


public class WinningNumbers {
    private final List<String> value;

    public WinningNumbers(String value) {
        validateWinningNumber(value);
        this.value = Parser.parseString(value);
    }
}
