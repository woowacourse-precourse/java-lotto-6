package lotto.view;

import static lotto.validator.InputValidator.validateAmount;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {
    private final static String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";

    public static int inputAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
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
