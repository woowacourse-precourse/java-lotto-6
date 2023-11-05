package lotto.util;

import lotto.exception.ErrorMessage;
import lotto.policy.LottoPolicy;

public class Validator {

    public static boolean verifyPurchaseAmount(String input) {
        try {
            verifyComposedOfNumbers(input);
            verifyAboveThousand(Integer.parseInt(input));
            verifyDivisibilityByThousand(Integer.parseInt(input));
            return true;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static void verifyComposedOfNumbers(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.INPUT_NOT_COMPOSED_OF_NUMBER.getMessage());
        }
    }

    private static void verifyAboveThousand(int input) {
        if (input < LottoPolicy.LOTTO_AMOUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_UNDER_THOUSAND.getMessage());
        }
    }

    private static void verifyDivisibilityByThousand(int input) {
        if (input % LottoPolicy.LOTTO_AMOUNT.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INDIVISIBLE_PURCHASE_AMOUNT.getMessage());
        }
    }

    private Validator() {
    }
}
