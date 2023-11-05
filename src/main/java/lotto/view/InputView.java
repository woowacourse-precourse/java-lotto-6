package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Converter;
import lotto.utils.InputValidator;

import java.util.List;

public class InputView {
    public static long inputMoney() {
        String money = Console.readLine();
        InputValidator.validateInputMoney(money);

        return Converter.convertMoney(money);
    }

    public static List<Integer> inputWinningNumber() {
        String winningNumber = Console.readLine();
        String[] numbers = winningNumber.split(",");
        InputValidator.validateInputWinningNumber(numbers);

        return Converter.convertWinningNumber(numbers);
    }

    public static int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        InputValidator.validateBonusNumber(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }
}
