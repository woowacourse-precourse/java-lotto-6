package lotto.service;

import lotto.model.WinningNumbers;
import lotto.validator.WinningNumberValidator;

import java.util.List;

public class WinningNumberService {
    private final WinningNumberValidator winningNumberValidator = new WinningNumberValidator();

    public WinningNumbers createWinningNumbers(String userInput){
        List<Integer> numbers =  winningNumberValidator.validateAndParse(userInput);
        return new WinningNumbers(numbers);
    }
}
