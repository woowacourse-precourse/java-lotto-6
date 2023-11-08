package lotto.util;

import lotto.enumeration.Constants;
import lotto.enumeration.ExceptionType;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Validator {
    public static boolean validateAmount(String input) {
        return validateAmountType(input) &&
                validateAmountRange(Integer.parseInt(input)) &&
                validateAmountMultiple(Integer.parseInt(input));
    }

    public static boolean validateAmountType(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(ExceptionType.INVALID_INPUT_TYPE.getMessage());
            return false;
        }
    }

    public static boolean validateAmountRange(int input) {
        try {
            if (input > Constants.AMOUNT_LIMIT.getConstant() ||
                    input < Constants.UNITS_OF_AMOUNT.getConstant()) {
                throw new InputMismatchException(ExceptionType.EXCEED_AMOUNT_LIMIT.getMessage());
            }
            return true;
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateAmountMultiple(int amount) {
        try {
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException(ExceptionType.AMOUNT_NOT_MULTIPLE_1000.getMessage());
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateLotto(String input) {
        List<Integer> nums;
        try {
            nums = validateLottoFormats(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionType.INVALID_LOTTO_FORMAT.getMessage());
            return false;
        }
    }

    private static List<Integer> validateLottoFormats(String input) {
        List<Integer> nums;
        validateLottoComma(input);
        nums = validateLottoFormat(input);

        return nums;
    }

    public static void validateLottoComma(String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new NumberFormatException();
        }
    }

    public static List<Integer> validateLottoFormat(String input) throws NumberFormatException {
        String[] inputArray = input.split(",");
        List<Integer> nums = new ArrayList<>();
        for (String str : inputArray) {
            nums.add(Integer.parseInt(str.replaceAll("\\s", "")));
        }
        return nums;
    }

    public static boolean validateBonus(String input) {
        if (validateBonusType(input)) {
            return true;
        }
        return false;
    }

    public static boolean validateBonusType(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(ExceptionType.INVALID_INPUT_TYPE.getMessage());
            return false;
        }
    }
}
