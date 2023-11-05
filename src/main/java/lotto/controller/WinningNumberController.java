package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;
import lotto.util.Parser;
import lotto.validator.DuplicationValidator;
import lotto.validator.OnlyNumberValidator;
import lotto.validator.WinningNumbersCountValidator;

import java.util.List;

public class WinningNumberController {
    private final Parser parser = new Parser();

    public void setInputToWinningNumbers(WinningNumbers winningNumbers, String playerInput) {
        List<String> inputValues = validateOnlyNumber(playerInput);
        List<Integer> inputNumbers = parser.stringListToNumberList(inputValues);
        validateNumbersCount(inputNumbers);
        validateDuplication(inputNumbers);
        winningNumbers.setWinningNumbers(inputNumbers);
    }

    public void setInputToBonusNumber(BonusNumber bonusNumber, String playerInput) {
        int inputNumber = parser.inputToNumber(playerInput);
        bonusNumber.setBonusNumber(inputNumber);
    }

    private List<String> validateOnlyNumber(String playerInput) {
        List<String> inputValues = parser.inputToStringList(playerInput);

        for (String value : inputValues) {
            OnlyNumberValidator onlyNumberValidator = new OnlyNumberValidator();
            onlyNumberValidator.validate(value);
        }
        return inputValues;
    }

    private void validateNumbersCount(List<Integer> inputNumbers) {
        WinningNumbersCountValidator winningNumbersCountValidator = new WinningNumbersCountValidator();
        winningNumbersCountValidator.validate(inputNumbers);
    }

    private void validateDuplication(List<Integer> inputNumbers) {
        DuplicationValidator duplicationValidator = new DuplicationValidator();
        duplicationValidator.validate(inputNumbers);
    }

}
