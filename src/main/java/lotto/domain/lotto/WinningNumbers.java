package lotto.domain.lotto;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    private static final String winningNumbersRegex = "\\d+(,*\\s*\\d*)*";
    private final List<Integer> numbers;

    public WinningNumbers(String winningNumbers) {
        validate(winningNumbers);
    }

    private void validate(String winningNumbers) {
        validateFormat(winningNumbers);
    }

    private void validateFormat(String winningNumbers) {
        if (!winningNumbers.matches(winningNumbersRegex)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에는 숫자, 공백, 콤마(,)만 입력할 수 있습니다.");
        }
    }


}
