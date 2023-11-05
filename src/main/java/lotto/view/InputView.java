package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.ErrorMessage;
import lotto.utils.GameMessage;

public class InputView {
    public static int getMoneyInput() {
        System.out.println(GameMessage.ENTER_PURCHASE_AMOUNT);
        String inputMoney = Console.readLine();
        validateInteger(inputMoney);
        return Integer.parseInt(inputMoney);
    }

    private static void validateInteger(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MONEY_NOT_INTEGER_ERROR.getMessage());
        }
    }
}