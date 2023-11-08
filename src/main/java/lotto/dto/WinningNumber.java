package lotto.dto;

import lotto.exception.LottoGameException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.validator.LottoValidator.*;

public class WinningNumber {
    private List<Integer> winningNumber;
    private static final String DELIMITER = ",";

    private WinningNumber(String userInput) throws LottoGameException {
        validateNullValue(userInput);
        this.winningNumber = Arrays
                .stream(userInput.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validInRangeNumber(winningNumber);
        validateDuplicateNumber(winningNumber);
    }

    public static WinningNumber create(String userInput) throws LottoGameException {
        return new WinningNumber(userInput);
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
