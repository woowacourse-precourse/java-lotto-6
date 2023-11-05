package lotto.controller.handler;

import java.util.Map;
import lotto.controller.converter.WinningNumberConverter;
import lotto.controller.validator.WinningNumberValidator;

public class WinningNumberHandler extends InputHandler<Map<Integer, Integer>> {
    public WinningNumberHandler(String winningNumbers) {
        this.input = winningNumbers;
        this.converter = new WinningNumberConverter();
        this.validator = new WinningNumberValidator();
    }

}
