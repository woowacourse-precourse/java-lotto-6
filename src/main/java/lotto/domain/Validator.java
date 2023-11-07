package lotto.domain;

import lotto.constants.ErrorMessages;

import java.util.Collections;
import java.util.List;

import static lotto.model.GameStatistics.LOTTERY_PRICE;


public class Validator {

    public static final Integer CORRECT_COMMA_COUNT = 5;
    public static final Integer FIRST_LOTTERY_NUMBER = 1;
    public static final Integer LAST_LOTTERY_NUMBER = 45;
    public static final Integer MAX_LOTTERY_COUNT = 6;
    public static final Integer NUMBERS_MIN_DUPLICATE_COUNT = 2;
    public static final Integer BONUS_NUMBER_MIN_DUPLICATE_COUNT = 1;


    public static boolean isEmpty_(String userInput) {
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

    public static boolean isValidCharacter(String userInput) {
        try {
            int commaCount = userInput.length() - userInput.replace(",", "").length();
            if (commaCount != CORRECT_COMMA_COUNT) {
                throw new IllegalArgumentException(ErrorMessages.IS_VALID_CHARACTER.writeErrorMessageByCase());
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

    public static boolean isUnder1000(Integer inputBudget) {
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

    public static boolean isIndivisible(Integer inputBudget) {
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

    public static boolean isOnValidRange(Integer winningNumber) {
        try {
            if (FIRST_LOTTERY_NUMBER > winningNumber || winningNumber > LAST_LOTTERY_NUMBER) {
                throw new IllegalArgumentException(ErrorMessages.IS_NUMBER_OUT_OF_RANGE.writeErrorMessageByCase());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public static boolean isWinningNumberDuplicate(Integer checkingNumber, List<Integer> referenceNumbers) {
        try {
            int duplicateNumberFrequency = Collections.frequency(referenceNumbers, checkingNumber);
            if (duplicateNumberFrequency >= NUMBERS_MIN_DUPLICATE_COUNT) {
                throw new IllegalArgumentException(ErrorMessages.ARE_WINNING_NUMBERS_DUPLICATE.writeErrorMessageByCase());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public static boolean isBonusNumberDuplicate(Integer checkingNumber, List<Integer> referenceNumbers) {
        try {
            int duplicateNumberFrequency = Collections.frequency(referenceNumbers, checkingNumber);
            if (duplicateNumberFrequency >= BONUS_NUMBER_MIN_DUPLICATE_COUNT) {
                throw new IllegalArgumentException(ErrorMessages.IS_BONUS_NUMBER_DUPLICATE.writeErrorMessageByCase());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public static boolean isCountOutOfRange(List<Integer> winningNumbers) {
        try {
            if (winningNumbers.size() != MAX_LOTTERY_COUNT) {
                throw new IllegalArgumentException(ErrorMessages.IS_NUMBER_COUNT_OUT_OF_RANGE.writeErrorMessageByCase());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public static boolean are_OnlyNumber_(String[] winningNumbers) {
        for (String winningNumber : winningNumbers) {
            if (Validator.isNumberOnly(winningNumber)) {
                return true;
            }
        }
        return false;
    }

    public static boolean areOutOfRange(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (Validator.isOnValidRange(winningNumber)) {
                return true;
            }
        }
        return false;
    }

    public static boolean areDuplicated(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (Validator.isWinningNumberDuplicate(winningNumber, winningNumbers)) {
                return true;
            }
        }
        return false;
    }
}
