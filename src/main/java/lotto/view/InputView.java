package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static void showMessage(String message) {
        System.out.println(message);
    }

    public String inputMoney() {
        showMessage(InputMessage.GET_MONEY.getValue());
        return Console.readLine();
    }

    public String inputNumbers() {
        showMessage(InputMessage.GET_NUMBERS.getValue());
        return Console.readLine();
    }

    public String bonusNumberMessage() {
        showMessage(InputMessage.GET_BONUS_NUMBER.getValue());
        return Console.readLine();
    }
}
