package lotto.controller;

import lotto.controller.converter.BonusNumberConverter;
import lotto.controller.validator.BonusNumberValidator;

public class BounsNumberHanlder extends InputHandler<Integer> {
    public BounsNumberHanlder(String BonusNumber) {
        this.input = BonusNumber;
        this.validator = new BonusNumberValidator();
        this.converter = new BonusNumberConverter();
    }

    @Override
    public void handle() {
        validator.validate(input);
    }

    @Override
    public Integer getHandledResult() {
        return converter.convert(input);
    }
}
