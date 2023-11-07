package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;
import lotto.util.Parser;
import lotto.validator.NumberOfRangeValidator;
import lotto.validator.NumbersDuplicationValidator;
import lotto.validator.OnlyNumberValidator;
import lotto.validator.WinningNumbersCountValidator;

import java.util.List;

public class WinningNumberController {
    private final Parser parser = new Parser();

    public void setInputToWinningNumbers(WinningNumbers winningNumbers, String playerInput) {
        List<String> inputValues = validateOnlyNumberValues(playerInput);
        List<Integer> inputNumbers = parser.stringListToNumberList(inputValues);
        validateNumbersCount(inputNumbers);

        inputNumbers.forEach(this::validateNumberOfRange);

        validateWinningNumbersDuplication(inputNumbers);
        winningNumbers.setWinningNumbers(inputNumbers);
    }

    public void setInputToBonusNumber(WinningNumbers winningNumbers, BonusNumber bonusNumber, String playerInput) {
        validateOnlyNumber(playerInput);
        int inputNumber = parser.inputToNumber(playerInput);
        validateNumberOfRange(inputNumber);
        validateBonusNumberDuplication(winningNumbers, inputNumber);
        bonusNumber.setBonusNumber(inputNumber);
    }

    private List<String> validateOnlyNumberValues(String playerInput) {
        List<String> inputValues = parser.inputToStringList(playerInput);

        for (String value : inputValues) {
            OnlyNumberValidator onlyNumberValidator = new OnlyNumberValidator();
            onlyNumberValidator.validate(value);
        }
        return inputValues;
    }

    private void validateOnlyNumber(String playerInput) {
        OnlyNumberValidator onlyNumberValidator = new OnlyNumberValidator();
        onlyNumberValidator.validate(playerInput);
    }

    private void validateNumbersCount(List<Integer> inputNumbers) {
        WinningNumbersCountValidator winningNumbersCountValidator = new WinningNumbersCountValidator();
        winningNumbersCountValidator.validate(inputNumbers);
    }

    private void validateWinningNumbersDuplication(List<Integer> inputNumbers) {
        NumbersDuplicationValidator numbersDuplicationValidator = new NumbersDuplicationValidator();
        numbersDuplicationValidator.validate(inputNumbers);
    }

    private void validateBonusNumberDuplication(WinningNumbers winningNumbers, int inputNumber) {
        BonusNumberDuplicationValidator bonusNumberDuplicationValidator = new BonusNumberDuplicationValidator();
        bonusNumberDuplicationValidator.getWinningNumbers(winningNumbers);
        bonusNumberDuplicationValidator.validate(inputNumber);
    }

    private void validateNumberOfRange(int number) {
        NumberOfRangeValidator numberOfRangeValidator = new NumberOfRangeValidator();
        numberOfRangeValidator.validate(number);
    }
}
