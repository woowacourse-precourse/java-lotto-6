package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.view.ViewMessage.*;

public class InputView {

    public static String inputPayment() {
        System.out.println(INPUT_PURCHASE_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE.getMessage());
        return Console.readLine();
    }
}
