package lotto.util;

import lotto.exception.ErrorMessage;

public class Validator {
    private static final int LOTTO_AMOUNT = 1000;

    public static boolean verifyPurchaseAmount(String input) {
        if (verifyComposedOfNumbers(input) || verifyAboveThousand(Integer.parseInt(input))
                || verifyDivisibilityByThousand(Integer.parseInt(input))) {
            return false;
        }
        return true;
    }

    private static boolean verifyComposedOfNumbers(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(ErrorMessage.INPUT_NOT_COMPOSED_OF_NUMBER.getMessage());
            return true;
        }
        return false;
    }

    private static boolean verifyAboveThousand(int input) {
        try {
            if (input < LOTTO_AMOUNT) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println(ErrorMessage.PURCHASE_AMOUNT_UNDER_THOUSAND.getMessage());
            return true;
        }
        return false;
    }

    private static boolean verifyDivisibilityByThousand(int input) {
        try {
            if (input % LOTTO_AMOUNT != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println(ErrorMessage.INDIVISIBLE_PURCHASE_AMOUNT.getMessage());
            return true;
        }
        return false;
    }

    private Validator() {
    }
}
