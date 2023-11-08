package lotto.dto;

import static lotto.validator.InputWinningBonusNumberValidator.validateBonusNumberRange;
import static lotto.validator.InputWinningBonusNumberValidator.validateOnlyPositiveNumberBonus;

public class InputBonus {
    private final int inputBonusNumber;

    public InputBonus(String inputBonusNumber) {
        validateOnlyPositiveNumberBonus(inputBonusNumber);
        int winningBonusNumber = convertToInteger(inputBonusNumber);
        validateBonusNumberRange(winningBonusNumber);
        this.inputBonusNumber = winningBonusNumber;
    }

    public int getInputBonusNumber() {
        return inputBonusNumber;
    }

    private int convertToInteger(String winningBonusNumberString) {
        return Integer.parseInt(winningBonusNumberString);
    }
}
