package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;
import lotto.util.Convertor;
import lotto.validation.InputValidator;

public class InputView {

    private InputView() {
    }

    public static int inputPurchasePrice() {
        String input = Console.readLine();
        try {
            InputValidator.validatePurchasePrice(input);
            return Convertor.convertStringToInt(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputPurchasePrice();
        }
    }

    public static WinningNumber inputWinningNumbers() {
        String input = Console.readLine();
        try {
            InputValidator.validateWinningNumber(input);
            return WinningNumber.from(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputWinningNumbers();
        }
    }

    public static BonusNumber inputBonusNumber() {
        String input = Console.readLine();
        try {
            InputValidator.validateBonusNumber(input);
            return BonusNumber.from(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputBonusNumber();
        }
    }
}
