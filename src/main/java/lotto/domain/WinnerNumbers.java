package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.convertor.AmountConvertor;
import lotto.domain.convertor.Convertor;
import lotto.domain.convertor.WinnerNumberConvertor;
import lotto.domain.convertor.WinnerNumberSpiltConvertor;
import lotto.domain.validator.Validator;
import lotto.domain.validator.WinnerNumberValidator;

public class WinnerNumbers {
    private final List<Integer> winnerNumbers;

    public WinnerNumbers(String number) {
        List<String> confirmedWinningNumbers = splitWinnerNumber(number);
        validateWinnerNumbers(confirmedWinningNumbers);
        this.winnerNumbers = convertWinnerNumber(confirmedWinningNumbers);
    }

    public List<Integer> getWinnerNumbers() {
        return this.winnerNumbers;
    }

    private void validateWinnerNumbers(List<String> winnerNumber) {
        Validator<List<String>> validator = new WinnerNumberValidator();
        validator.validate(winnerNumber);
    }

    private List<String> splitWinnerNumber(String input) {
        Convertor<String, List<String>> convertor = new WinnerNumberSpiltConvertor();
        return convertor.convert(input);
    }

    private List<Integer> convertWinnerNumber(List<String> input) {
        Convertor<List<String>, List<Integer>> convertor = new WinnerNumberConvertor();
        return convertor.convert(input);
    }
}
