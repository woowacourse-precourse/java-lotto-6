package lotto.input;

import camp.nextstep.edu.missionutils.Console;

import static lotto.output.Constants.PurchaseHandlerConstants.MINIMUM_AMOUNT_ERROR_MESSAGE;
import static lotto.output.Constants.PurchaseHandlerConstants.THOUSAND_FORMAT_ERROR_MESSAGE;

public class PurchaseHandler {
    public static int getAmount() {
        while (true) {
            try {
                int convertedInt = convertValidAmount(Console.readLine());
                validateAmount(convertedInt);
                return convertedInt;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private static int convertValidAmount(String input) {
        try {
            String amountInput = input.replace(",", "");
            return Integer.parseInt(amountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(THOUSAND_FORMAT_ERROR_MESSAGE);
        }

    }


    private static void validateAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException(MINIMUM_AMOUNT_ERROR_MESSAGE);
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(THOUSAND_FORMAT_ERROR_MESSAGE);
        }
    }

}