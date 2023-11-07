package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.PrintMessage;

public class InputView {
    public int requestPayment() {
        System.out.println(PrintMessage.PAYMENT_REQUEST.getMessage());
        return Integer.parseInt(Console.readLine());
    }

    public String requestWinningNumber() {
        System.out.println(PrintMessage.WINNING_NUMBER_REQUEST.getMessage());
        return Console.readLine();
    }

    public int requestBonusNumber() {
        System.out.println(PrintMessage.BONNUS_NUMBER_REQUEST.getMessage());
        return Integer.parseInt(Console.readLine());
    }
}
