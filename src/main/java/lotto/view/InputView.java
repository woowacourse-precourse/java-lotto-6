package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.InputMessage;

public class InputView {
    public static String getAmountOfMoney() {
        System.out.println(InputMessage.MONEY_TO_BUY_LOTTO.getMessage());

        return Console.readLine();
    }

    public static String getWinningNumbers() {
        System.out.println(InputMessage.WINNING_LOTTO_NUMBER.getMessage());

        return Console.readLine();
    }

    public static String getBonusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER.getMessage());

        return Console.readLine();
    }
}
