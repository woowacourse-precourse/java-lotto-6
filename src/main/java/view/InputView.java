package view;

import static constant.ConstantMessage.INPUT_BONUS_NUMBER;
import static constant.ConstantMessage.INPUT_MONEY;
import static constant.ConstantMessage.INPUT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
    }

    public static String money() {
        System.out.println(INPUT_MONEY.getMessage());
        String lottoMoney = Console.readLine();
        return lottoMoney.trim();
    }

    public static String winningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    public static String bonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
