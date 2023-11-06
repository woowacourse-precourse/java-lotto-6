package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Validator;

public class InputWinnerNumberService {

    private List<Integer> winnerNumbers;

    public void checkRightWinnerNumbers(Validator validator, String inputWinnerNumbers) {
        List<String> splitedInputWinnerNumbers = List.of(inputWinnerNumbers.split(","));
        validator.validateRightCommaCount(inputWinnerNumbers, splitedInputWinnerNumbers);
        validator.validateWinnumberOnlyNumber(splitedInputWinnerNumbers);
        winnerNumbers = splitedInputWinnerNumbers.stream().map(Integer::parseInt)
            .collect(Collectors.toList());
        validator.validateWinnumberRangeNumber(winnerNumbers);
        validator.validateNumberLength(winnerNumbers);
    }

    public List<Integer> convertedWinnerNumbers() {
        return winnerNumbers;
    }

    public void init() {
        winnerNumbers = new ArrayList<>();
    }
}
