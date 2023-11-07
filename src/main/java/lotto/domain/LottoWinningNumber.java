package lotto.domain;

import lotto.validator.PlayerInputValidator;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNumber {
    private static List<Integer> winningNumbers;

    public static List<Integer> getWinningNumbers(String winningNumber) {
        String[] numbers = winningNumber.split(",");
        winningNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            PlayerInputValidator.validateNumber(numbers[i]);
            winningNumbers.add(Integer.parseInt(numbers[i]));
        }
        return winningNumbers;
    }
}
