package view;

import camp.nextstep.edu.missionutils.Console;
import validator.InputValidator;

public class InputView {
    public static int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        InputValidator.validateInputIsNumeric(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    public static String inputWinningNumbers() {
        String winningNumbers = Console.readLine();
        InputValidator.validateSeparatedByComma(winningNumbers);
        return winningNumbers;
    }

    public static int inputSpend() {
        String spend = Console.readLine();
        InputValidator.validateInputIsNumeric(spend);
        return Integer.parseInt(spend);
    }
}
