package domain;

import lotto.Validation;

import java.util.List;

public class LottoDraw {

    public List<Integer> winNumbers(String winNumbersInput) {
        Validation.validateWinNumbersFormatByChar(winNumbersInput);
        Validation.validateWinNumbersFormatByLength(winNumbersInput);
        Validation.validateWinNumbersFormatBySide(winNumbersInput);
        List<Integer> winNumbersInputToArrayList = Validation.validateWinNumbersInRange(winNumbersInput);
        Validation.validateWinNumbersByDuplicate(winNumbersInputToArrayList);
        return winNumbersInputToArrayList;
    }
}
