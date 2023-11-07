package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.PrintMessage;

public class InputView {
    public String requestPayment() {
        System.out.println(PrintMessage.PAYMENT_REQUEST.getMessage());
        return Console.readLine().trim();
    }

    public String requestWinningNumber() {
        System.out.println(PrintMessage.WINNING_NUMBER_REQUEST.getMessage());
        return Console.readLine().replace(" ", "");
    }

    public String requestBonusNumber() {
        System.out.println(PrintMessage.BONUS_NUMBER_REQUEST.getMessage());
        return Console.readLine().trim();
    }
}
