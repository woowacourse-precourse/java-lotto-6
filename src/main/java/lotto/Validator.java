package lotto;

import static lotto.Controller.LOTTERY_PRICE;

public class Validator {

    public static Boolean validationFlag = true;

    public static void isInputEmpty(String userInput) {
        try {
            if (userInput.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessages.IS_EMPTY.writeErrorMessageByCase());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            try {
                throw new IllegalArgumentException(ErrorMessages.IS_NUMBER.writeErrorMessageByCase());
            } catch (IllegalArgumentException ee) {
                System.out.println(ee.getMessage());
                return true;
            }
        }
        return false;
    }

    public static void isPriceUnder1000(Integer userInputNumber) {
        try {
            if (userInputNumber < LOTTERY_PRICE) {
                throw new IllegalArgumentException(ErrorMessages.IS_UNDER_1000.writeErrorMessageByCase());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void isPriceIndivisible(Integer userInputNumber) {
        try {
            if ((userInputNumber % LOTTERY_PRICE) != 0) {
                throw new IllegalArgumentException(ErrorMessages.IS_INDIVISIBLE_BY_1000.writeErrorMessageByCase());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
