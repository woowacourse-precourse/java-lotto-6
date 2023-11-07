package lotto.validation;

import java.util.Arrays;
import java.util.HashSet;

public class InputValidation {
    public int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다.");
        }
    }

    public void isThousandMultiple(String input) {
        int payment = isNumber(input);
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 1000원 단위가 아닙니다.");
        }
    }

    public void validateWinningNumbers(String input) {
        HashSet<String> winningNumbers = new HashSet<>(Arrays.asList(input.split(",")));
        checkWinningNumbersAreNumeric(winningNumbers);
        hasSixNumbers(winningNumbers);
    }

    private void checkWinningNumbersAreNumeric(HashSet<String> winningNumbers) {
        winningNumbers.forEach(this::isNumber);
    }

    private void hasSixNumbers(HashSet<String> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 6가지가 아닙니다.");
        }
    }
}
