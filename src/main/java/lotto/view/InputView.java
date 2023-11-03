package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Utils;

public class InputView {

    private static void showMessage(String message) {
        System.out.println(message);
    }

    public int inputAmount() {
        showMessage(InputMessage.GET_MONEY.getValue());
        return Utils.convertStringToInteger(Console.readLine());
    }

    public String inputWinningNumbers() {
        showMessage(InputMessage.GET_NUMBERS.getValue());
        return Console.readLine();
    }

    public String bonusNumberMessage() {
        showMessage(InputMessage.GET_BONUS_NUMBER.getValue());
        return Console.readLine();
    }
}
