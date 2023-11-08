package lotto.service.lotto;

import lotto.model.BonusNumber;
import lotto.model.WinningNumbers;
import lotto.view.input.parser.numberParser;
import lotto.view.input.validator.BonusNumberValidator;
import lotto.view.input.validator.WinningNumberValidator;

import java.util.List;

import static lotto.view.input.parser.numberParser.separateIntegers;

public class WinningNumberService {
    private final WinningNumberValidator winningNumberValidator = new WinningNumberValidator();
    private final BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();

    public WinningNumbers createWinningNumbers(String userInput) {
        winningNumberValidator.validate(userInput);
        List<Integer> validatedNumbers = separateIntegers(userInput);
        return new WinningNumbers(validatedNumbers);
    }

    public BonusNumber createBonusNumber(String userInput, List<Integer> winningNumbers) {
        bonusNumberValidator.validate(userInput, winningNumbers);
        int validatedNumber = numberParser.parseInteger(userInput);
        return new BonusNumber(validatedNumber);
    }
}
