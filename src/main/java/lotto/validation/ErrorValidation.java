package lotto.validation;

import java.util.List;
import java.util.regex.Pattern;
import lotto.readUserInput.WinningNumbers;

public class ErrorValidation {

    public static void isNumberVerify(String userInput) {
        if (!Pattern.matches("^\\d+$", userInput)) {
            throw new IllegalArgumentException();
        }
    }

    public static void isAlreadyReadNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public static void isNumberInRange(int bonusNumber) {
        if (!((bonusNumber >= 1) && (bonusNumber <= 45))) {
            throw new IllegalArgumentException();
        }
    }
}
