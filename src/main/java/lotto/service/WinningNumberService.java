package lotto.service;

import lotto.model.WinningNumbers;
import lotto.validator.WinningNumbersParser;
import lotto.validator.WinningNumberValidator;

import java.util.List;

public class WinningNumberService {
    private final WinningNumberValidator winningNumberValidator = new WinningNumberValidator();

    public WinningNumbers createWinningNumbers(String userInput){
        winningNumberValidator.validateWinningNumbers(userInput);
        List<Integer> numbers = WinningNumbersParser.splitAndConvertToIntegers(userInput);
        return new WinningNumbers(numbers);
    }
}
