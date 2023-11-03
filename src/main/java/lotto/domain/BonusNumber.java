package lotto.domain;

import lotto.service.InputService;
import lotto.service.ValidateService;

public class BonusNumber {
    private final InputService inputService = new InputService();
    private final ValidateService validateService = new ValidateService();
    private int bonusNumber;

    public int getBonusNumber() {
        return inputBonusNumber();
    }

    private int inputBonusNumber(){
        bonusNumber = validateService.validateNumber(inputService.inputValue());
        validateService.validateBonusNumber(bonusNumber);
        return bonusNumber;
    }
}
