package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constant.PrintMessage;
import lotto.util.Parser;

public class InputView {
    public int requestPayment() {
        System.out.println(PrintMessage.PAYMENT_REQUEST.getMessage());
        return Integer.parseInt(Console.readLine().trim());
    }

    public List<Integer> requestWinningNumber() {
        System.out.println("\n" + PrintMessage.WINNING_NUMBER_REQUEST.getMessage());
        return Parser.toIntegerList(Console.readLine().replace(" ", ""));
    }

    public int requestBonusNumber() {
        System.out.println(PrintMessage.BONNUS_NUMBER_REQUEST.getMessage());
        return Integer.parseInt(Console.readLine().trim());
    }
}
