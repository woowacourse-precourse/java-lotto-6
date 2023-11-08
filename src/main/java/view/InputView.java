package view;

import camp.nextstep.edu.missionutils.Console;
import validator.Validator;

public class InputView {
    public static int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        Validator.validateInputIsNumeric(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    public static String inputWinningNumbers() {
        String winningNumbers = Console.readLine();
        Validator.validateSeparatedByComma(winningNumbers);
        return winningNumbers;
    }

    public static int inputSpend() {
        String spend = Console.readLine();
        Validator.validateInputIsNumeric(spend);
        return Integer.parseInt(spend);
    }
}
