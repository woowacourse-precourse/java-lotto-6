package lotto.controller;

public class Validator {
    public static boolean isBuyAmountValid(String playerInput) {
        try {
            int buyAmount = Integer.parseInt(playerInput);
            if (buyAmount <= 0) {
                Exception.isNotPlusInt();
            }

            if (buyAmount % 1000 != 0) {
                Exception.isNotThousandUnit();
            }

        } catch (NumberFormatException e) {
            Exception.isNotNumber();
        }

        return true;
    }
}
