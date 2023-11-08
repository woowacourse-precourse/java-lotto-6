package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Constants;

public class InputView {

    public static String inputPurchaseAmount() {
        System.out.println(Constants.PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(Constants.WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(Constants.BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }

}
