package view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public static int getPurchaseAmount() {
        String userInput;

        System.out.println(ENTER_PURCHASE_AMOUNT);
        do {
            userInput = Console.readLine();
        } while (!validateUserInput(userInput));

        return Integer.parseInt(userInput);
    }

    private static boolean validateUserInput(String userInput) {
        try {
            InputException.canBeConvertedToInteger(userInput);
            InputException.isValidAmount(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}