package lotto.domain;

import lotto.utils.ValidateUtils;

import java.util.*;

import static lotto.utils.ValidateUtils.validateNumeric;

public class WinningNumbers {
    private final int LOWER_BOUND_NUMBER = 1;
    private final int UPPER_BOUND_NUMBER = 45;
    private final List<Integer> winningNumbers;

    private ValidateUtils validateUtils = new ValidateUtils();
    private WinningNumbers(List<Integer> winningNumbers) {
        validateUtils.validateRange(winningNumbers, LOWER_BOUND_NUMBER, UPPER_BOUND_NUMBER);
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers from(String inputString) {
        List<Integer> winningNumbers = convertInputToWinningNumbers(inputString);

        return new WinningNumbers(winningNumbers);
    }

    public static List<Integer> convertInputToWinningNumbers(String inputString) {
        List<Integer> winningNumbers = new ArrayList<>();

        for (String splitNumber : inputString.split(",")) {
            validateNumeric(splitNumber);
            winningNumbers.add(Integer.parseInt(splitNumber));
        }

        return winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
