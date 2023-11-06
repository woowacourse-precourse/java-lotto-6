package lotto.service;

import static lotto.constant.Delimiter.COMMA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Validator;

public class InputWinNumberService {

    private List<Integer> winNumbers;

    public void checkRightWinnerNumbers(Validator validator, String inputWinnerNumbers) {
        List<String> splitedInputWinNumbers = List.of(
            inputWinnerNumbers.split(COMMA.getDelimiter()));
        validator.validateRightCommaCount(inputWinnerNumbers, splitedInputWinNumbers);
        validator.validateWinnumberOnlyNumber(splitedInputWinNumbers);
        winNumbers = splitedInputWinNumbers.stream().map(Integer::parseInt)
            .collect(Collectors.toList());
        validator.validateConvertedWinnerNumber(winNumbers);
    }

    public List<Integer> convertedWinnerNumbers() {
        return winNumbers;
    }

    public void init() {
        winNumbers = new ArrayList<>();
    }
}
