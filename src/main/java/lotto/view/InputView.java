package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidation;

public class InputView {
    public interface EachInput<T> {
        T input();
    }

    public static <T> T commonInput(EachInput<T> eachInput) {
        try {
            return eachInput.input();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return commonInput(eachInput);
        }
    }

    public static int paymentAmount() {
        String paymentAmount = Console.readLine();
        return InputValidation.validateDigitAndConvertToDigit(paymentAmount);
    }

    public static int[] winningNumber() {
        String winningNumber = Console.readLine();
        return InputValidation.validateDigitsAndConvertToDigits(winningNumber);
    }

    public static int bonusNumber() {
        String bonusNumber = Console.readLine();
        return InputValidation.validateDigitAndConvertToDigit(bonusNumber);
    }
}
