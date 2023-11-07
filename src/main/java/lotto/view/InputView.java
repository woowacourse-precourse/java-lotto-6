package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Converter;
import lotto.utils.InputValidator;

import java.util.List;

import static lotto.constant.InputMessage.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.constant.InputMessage.INPUT_MONEY_MESSAGE;
import static lotto.constant.InputMessage.INPUT_WINNING_NUMBER_MESSAGE;

public class InputView {
    public static long inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE.getMessage());
        String money = Console.readLine();
        InputValidator.validateInputMoney(money);

        return Converter.convertMoney(money);
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE.getMessage());
        String winningNumber = Console.readLine();
        String[] numbers = winningNumber.split(",");
        InputValidator.validateInputWinningNumber(numbers);

        return Converter.convertWinningNumber(numbers);
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE.getMessage());
        String bonusNumber = Console.readLine();
        InputValidator.validateBonusNumber(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }
}
