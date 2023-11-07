package lotto.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Validator {
    public static String validationNull(String input) {
        if (Objects.isNull(input) || input.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 내용이 없습니다.");
        }
        return input;
    }

    public static int validationNumber(String input) {
        if (!Pattern.matches("^[0-9]*$", input)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
        return Integer.parseInt(input);
    }

    public static void validationBonusNumber(int bonusNumber, Lotto lotto) {
        WinnerLotto.of(lotto, bonusNumber);
    }
}
