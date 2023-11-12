package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.OutputMessage;

public class InputView {
    public static String inputPurchase() {
        System.out.println(OutputMessage.ENTER_PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(OutputMessage.INPUT_LOTTO_WINNING_NUMBER.getMessage());
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(OutputMessage.INPUT_LOTTO_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
