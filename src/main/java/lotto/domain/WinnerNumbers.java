package lotto.domain;

import java.util.List;
import lotto.domain.convertor.Convertor;
import lotto.domain.convertor.WinnerNumberConvertor;
import lotto.domain.convertor.WinnerNumberSpiltConvertor;
import lotto.domain.validator.Validator;
import lotto.domain.validator.WinnerNumberValidator;

public class WinnerNumbers {
    private final Lotto winnerNumbers;

    public WinnerNumbers(String inputWinnerNumber) {
        List<String> splitWinnerNumbers = splitWinnerNumber(inputWinnerNumber);
        validateWinnerNumbers(splitWinnerNumbers);
        this.winnerNumbers = new Lotto(convertWinnerNumber(splitWinnerNumbers));
    }

    public List<Integer> getWinnerNumbers() {
        return this.winnerNumbers.getNumbers();
    }

    private void validateWinnerNumbers(List<String> winnerNumber) {
        Validator<List<String>> validator = new WinnerNumberValidator();
        validator.validate(winnerNumber);
    }

    private List<String> splitWinnerNumber(String inputWinnerNumber) {
        Convertor<String, List<String>> convertor = new WinnerNumberSpiltConvertor();
        return convertor.convert(inputWinnerNumber);
    }

    private List<Integer> convertWinnerNumber(List<String> splitWinnerNumbers) {
        Convertor<List<String>, List<Integer>> convertor = new WinnerNumberConvertor();
        return convertor.convert(splitWinnerNumbers);
    }
}
