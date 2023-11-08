package lotto.util;

import lotto.enumeration.ExceptionType;

public class Validator {

    public static boolean validateAmountType(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(ExceptionType.INVALID_INPUT_TYPE.getMessage());
            return false;
        }
    }

    public static boolean validateLottoInput(String input) {
        try {
            validateLottoComma(input);
            validateLottoFormat(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(ExceptionType.INVALID_LOTTO_FORMAT.getMessage());
            return false;
        }
    }

    public static void validateLottoComma(String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new NumberFormatException();
        }
    }

    public static void validateLottoFormat(String input) throws NumberFormatException {
        String[] inputArray = input.split(",");
        for (String str : inputArray) {
            Integer.parseInt(str.replaceAll("\\s", ""));
        }
    }

    public static boolean validateBonus(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(ExceptionType.INVALID_INPUT_TYPE.getMessage());
            return false;
        }
    }
}
