package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public String readPurchaseAmount() {
        try {
            System.out.println(PROMPT_PURCHASE_AMOUNT);
            String userInput = Console.readLine();
            validatePurchaseAmount(userInput);

            return userInput;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPurchaseAmount();
        }
    }

    private void validatePurchaseAmount(String userInput) {
        validateEmpty(userInput);
        validateDigit(userInput);
        validateThousand(userInput);
        validateRange(userInput);
    }

    private void validateRange(String userInput) {
        int tmp = Integer.parseInt(userInput);
        if (tmp <= 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void validateThousand(String userInput) {
        int tmp = Integer.parseInt(userInput);
        if (tmp % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
    private void validateEmpty(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException("[ERROR}");
        }
    }

    private void validateDigit(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
