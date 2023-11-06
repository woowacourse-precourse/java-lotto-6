package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String MESSAGE_FOR_PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요.";

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String ERROR_MESSAGE_FOR_PURCHASE_AMOUNT_INPUT = "구앱금액은 1000원 단위로 숫자를 입력해 주세요.";

    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmountWithInput();
    }

    private static int getPurchaseAmountWithInput() {
        System.out.println(MESSAGE_FOR_PURCHASE_AMOUNT_INPUT);
        while (true) {
            String purchaseAmountInput = Console.readLine();
            try {
                validatePurchaseAmountInput(purchaseAmountInput);
            } catch (IllegalArgumentException e) {
                printErrorMessage(ERROR_MESSAGE_FOR_PURCHASE_AMOUNT_INPUT);
                continue;
            }
            return Integer.parseInt(purchaseAmountInput);
        }
    }

    private static void validatePurchaseAmountInput(String purchaseAmountInput) {
        try {
            int purchaseAmount = Integer.parseInt(purchaseAmountInput);
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE_PREFIX + errorMessage);
    }
}
