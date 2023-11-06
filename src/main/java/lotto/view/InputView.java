package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PrintMessage;
import lotto.utils.InputException;

public class InputView {

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        String purchaseAmount = "";

        while (true) {
            try {
                purchaseAmount = printAndInput(PrintMessage.INPUT_PURCHASE_AMOUNT);
                InputException.validatePurchaseAmount(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return Integer.parseInt(purchaseAmount);
    }

    public static String printAndInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
