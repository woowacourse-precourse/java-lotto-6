package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.validator.InputValidator;

public class Input {
    public static final String SEPARATION_SIGN = ",";

    public int purchasePrice() {
        String input = defaultReadLine();
        purchaseValidate(input);
        return Integer.parseInt(input);
    }

    private void purchaseValidate(String input) {
        InputValidator.onlyNumber(input);
        InputValidator.inNumberRange(input);
    }

    public List<Integer> winningNumbers() {
        String input = defaultReadLine();
        winningNumbersValidate(input);
        return Arrays.stream(input.split(SEPARATION_SIGN))
                .map(Integer::parseInt)
                .toList();
    }

    private void winningNumbersValidate(String input) {
        InputValidator.commaCountDifferent(input);
        List<String> dividedInput = Arrays.stream(input.split("" + SEPARATION_SIGN)).toList();
        dividedInput.forEach(this::numberValidate);
    }

    public String bonusNumber() {
        return defaultReadLine();
    }

    private String defaultReadLine() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
