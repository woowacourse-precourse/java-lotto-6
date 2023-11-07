package lotto.service;

import lotto.model.BonusNumber;
import lotto.model.WinningNumbers;
import lotto.validator.input.BonusNumberValidator;
import lotto.validator.input.WinningNumberValidator;

import java.util.List;

public class WinningNumberService {
    private final WinningNumberValidator winningNumberValidator = new WinningNumberValidator();
    private final BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();

    public WinningNumbers createWinningNumbers(String userInput) {
        List<Integer> numbers = winningNumberValidator.validateAndParse(userInput);
        return new WinningNumbers(numbers);
    }

    public BonusNumber createBonusNumber(String userInput, List<Integer> winningNumbers) {
        int number = bonusNumberValidator.validateAndParse(userInput, winningNumbers);
        return new BonusNumber(number);
    }
}
