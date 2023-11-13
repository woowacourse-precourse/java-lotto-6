package lotto.controller.handler;

import lotto.controller.converter.BonusNumberConverter;
import lotto.controller.validator.BonusNumberValidator;

public class BonusNumberHandler extends InputHandler<Integer> {
    public BonusNumberHandler(String BonusNumber) {
        this.input = BonusNumber;
        this.validator = new BonusNumberValidator();
        this.converter = new BonusNumberConverter();
    }
}
