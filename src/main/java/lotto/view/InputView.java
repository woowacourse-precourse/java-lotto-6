package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;
import lotto.view.message.PrintMessage;

public class InputView {

    public int inputPurchaseAmount() {
        String input;
        while (true) {
            System.out.println(PrintMessage.INPUT_PURCHASE_AMOUNT.getMessage());
            input = Console.readLine();
            if (Validator.verifyPurchaseAmount(input)) {
                break;
            }
        }
        System.out.println();
        return Integer.parseInt(input);
    }
}
