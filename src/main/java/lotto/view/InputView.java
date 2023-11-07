package lotto.view;

import static lotto.util.Validator.isNumber;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constant.PrintMessage;
import lotto.util.Parser;

public class InputView {
    public int requestPayment() {
        System.out.println(PrintMessage.PAYMENT_REQUEST.getMessage());
        String input = Console.readLine().trim();
        isNumber(input);
        return Integer.parseInt(input);
    }

    public List<Integer> requestWinningNumber() {
        System.out.println(PrintMessage.WINNING_NUMBER_REQUEST.getMessage());
        return Parser.toIntegerList(Console.readLine().replace(" ", ""));
    }

    public int requestBonusNumber() {
        System.out.println(PrintMessage.BONNUS_NUMBER_REQUEST.getMessage());
        return Integer.parseInt(Console.readLine());
    }
}
