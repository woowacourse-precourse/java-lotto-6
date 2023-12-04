package lotto.model;

import static lotto.PlayLottoGame.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private final List<Integer> winningNumber;

    public WinningNumber(String winningNumber){
        String validateNumber = validator.validateWinningNumbers(winningNumber);
        this.winningNumber = Arrays.stream(validateNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
