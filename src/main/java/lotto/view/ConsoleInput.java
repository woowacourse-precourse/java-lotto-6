package lotto.view;

import static lotto.validator.InputValidator.validateAmount;
import static lotto.view.constants.PrintType.REQUEST_PURCHASE_AMOUNT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {

    public static int inputAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE.getMessage());
        int amount;
        amount = judgeReEnterAmountValue();
        return amount;
    }

    private static int judgeReEnterAmountValue() {
        int amount;
        while (true) {
            try {
                amount = validateAmount(Console.readLine());
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return amount;
    }
}
