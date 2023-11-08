package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Domain.Verifier;
import lotto.View.Constants.InfoMessage;

public class InputView {

    public static String gameMoney() {
        System.out.println(InfoMessage.INPUT_MONEY_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String winningNumber() {
        System.out.println(InfoMessage.INPUT_WINNING_NUMBERS_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String bonusNumber () {
        System.out.println(InfoMessage.INPUT_LUCKY_NUMBER_MESSAGE.getMessage());
        return Console.readLine();
    }
}
