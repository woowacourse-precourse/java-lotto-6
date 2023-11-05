package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.InputParser;
import lotto.util.Validator;
import lotto.view.message.PrintMessage;

public class InputView {

    public int inputPurchaseAmount() {
        String input;
        while (true) {
            System.out.println(PrintMessage.PURCHASE_AMOUNT_INPUT_MESSAGE.getMessage());
            input = Console.readLine();
            if (Validator.verifyPurchaseAmount(input)) {
                break;
            }
        }
        System.out.println();
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinNumber() {
        String input;
        while (true) {
            System.out.println(PrintMessage.WIN_NUMBER_INPUT_MESSAGE.getMessage());
            input = Console.readLine();
            if (Validator.verifyWinNumber(input)) {
                break;
            }
        }
        System.out.println();
        return InputParser.parseIntegerList(input);
    }
}
