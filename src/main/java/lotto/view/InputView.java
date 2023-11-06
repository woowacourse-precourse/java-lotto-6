package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.contants.InputMessage;
import lotto.view.validation.InputValidator;

public class InputView {

    public static double getPurchaseAmount() {
        while (true) {
            System.out.println(InputMessage.PURCHASE_AMOUNT.getValue());
            String inputAmount = Console.readLine();
            try {
                InputValidator.validateBlank(inputAmount);
                InputValidator.validateNumber(inputAmount);
                return Double.parseDouble(inputAmount);
            } catch (IllegalArgumentException e) {
                System.out.println();
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }
}
