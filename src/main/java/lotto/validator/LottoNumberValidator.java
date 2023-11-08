package lotto.validator;

import lotto.constant.Config;

public class LottoNumberValidator {
    private LottoNumberValidator() {
    }
    public static void validate(String stringNumber) {
        validateInteger(stringNumber);
        validateRange(stringNumber);
    }

    private static void validateInteger(String stringNumber) {
        try {
            Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid amount format. Please enter a valid integer.");
        }
    }

    private static void validateRange(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        if(number < Config.LOTTO_NUMBER_MIN.getConfig() || number > Config.LOTTO_NUMBER_MAX.getConfig()) {
            throw  new IllegalArgumentException("The number is out of range.");
        }
    }
}
