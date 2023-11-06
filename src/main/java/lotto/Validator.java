package lotto;

import static lotto.Controller.LOTTERY_PRICE;

public class Validator {

    public static Boolean validationFlag = false;

    public static boolean isInputEmpty(String userInput) {
        try {
            if (userInput.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessages.IS_EMPTY.writeErrorMessageByCase());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public static boolean isNumber(String userInput) {
        if (userInput.equals("")) {
            return false;
        }
        try {
            System.out.println(Integer.parseInt(userInput));
//            Integer.parseInt(userInput);
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

    public static boolean isPriceUnder1000(String userInput) {
        try {
            int inputBudget = Integer.parseInt(userInput);
            if (inputBudget < LOTTERY_PRICE) {
                throw new IllegalArgumentException(ErrorMessages.IS_UNDER_1000.writeErrorMessageByCase());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public static boolean isPriceIndivisible(String userInput) {
        try {
            int inputBudget = Integer.parseInt(userInput);
            if ((inputBudget % LOTTERY_PRICE) != 0) {
                throw new IllegalArgumentException(ErrorMessages.IS_INDIVISIBLE_BY_1000.writeErrorMessageByCase());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }
}
