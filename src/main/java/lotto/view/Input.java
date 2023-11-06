package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.validator.InputValidator;

public class Input {
    public static final char SEPARATION_SIGN = ',';

    public int purchasePrice() {
        String input = defaultReadLine();
        numberValidate(input);
        return Integer.parseInt(input);
    }

    public List<Integer> winningNumbers() {
        String input = defaultReadLine();
        winningNumbersValidate(input);
        return Arrays.stream(input.split("" + SEPARATION_SIGN))
                .map(Integer::parseInt)
                .toList();
    }

    private void winningNumbersValidate(String input) {
        InputValidator.commaCountDifferent(input);
        List<String> dividedInput = Arrays.stream(input.split("" + SEPARATION_SIGN)).toList();
        dividedInput.forEach(this::numberValidate);
    }

    public String bonusNumber() {
        String input = defaultReadLine();
        numberValidate(input);
        return input;
    }

    private void numberValidate(String input) {
        InputValidator.notNumber(input);
        InputValidator.overNumberRange(input);
    }

    private String defaultReadLine() {
        return Console.readLine();
    }
}
