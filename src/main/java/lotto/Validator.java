package lotto;

import java.util.Collections;
import java.util.List;

import static lotto.Controller.LOTTERY_PRICE;

public class Validator {

    public static final Integer FIRST_LOTTERY_NUMBER = 1;
    public static final Integer LAST_LOTTERY_NUMBER = 45;
    public static final Integer MAX_LOTTERY_COUNT = 6;

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

    public static boolean isNumberOnly(String userInput) {
        if (userInput.equals("")) {
            return false;
        }
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            try {
                throw new IllegalArgumentException(ErrorMessages.IS_NUMBER_ONLY.writeErrorMessageByCase());
            } catch (IllegalArgumentException ee) {
                System.out.println(ee.getMessage());
                return true;
            }
        }
        return false;
    }

    public static boolean isPriceUnder1000(Integer inputBudget) {
        try {
            if (inputBudget < LOTTERY_PRICE) {
                throw new IllegalArgumentException(ErrorMessages.IS_UNDER_1000.writeErrorMessageByCase());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public static boolean isPriceIndivisible(Integer inputBudget) {
        try {
            if ((inputBudget % LOTTERY_PRICE) != 0) {
                throw new IllegalArgumentException(ErrorMessages.IS_INDIVISIBLE_BY_1000.writeErrorMessageByCase());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public static boolean isNumberOnValidRange(Integer winningNumber) {
        try {
            if (FIRST_LOTTERY_NUMBER < winningNumber || winningNumber < LAST_LOTTERY_NUMBER) {
                throw new IllegalArgumentException(ErrorMessages.IS_NUMBER_OUT_OF_RANGE.writeErrorMessageByCase());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public static boolean isNumberDuplicate(Integer winningNUmber, List<Integer> winningNumbers) {
        try {

            int duplicateNumberFrequency = Collections.frequency(winningNumbers, winningNUmber);

            if (duplicateNumberFrequency > 1) {
                throw new IllegalArgumentException(ErrorMessages.IS_NUMBER_DUPLICATE.writeErrorMessageByCase());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public static boolean isNumberCountOutOfRange(List<Integer> winningNumbers) {
        try {
            if (winningNumbers.size() > MAX_LOTTERY_COUNT) {
                throw new IllegalArgumentException(ErrorMessages.IS_UNDER_1000.writeErrorMessageByCase());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }
}
