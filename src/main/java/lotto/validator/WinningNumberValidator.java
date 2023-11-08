package lotto.validator;

import lotto.constant.Config;

public class WinningNumberValidator {
    private WinningNumberValidator() {
    }

    public static void validate(String stringNumbers) {
        validateListLength(stringNumbers);
        validateElements(stringNumbers);
    }


    private static void validateListLength(String stringNumbers) {
        int length = stringNumbers.split(",", -1).length;
        if(length != Config.NUMBER_OF_LOTTO_NUMBERS.getConfig()) {
            throw new IllegalArgumentException("The input must be list of length 6.");
        }
    }

    private static void validateElements(String stringNumbers) {
        for(String stringNumber : stringNumbers.split(",")) {
            LottoNumberValidator.validate(stringNumber);
        }
    }

}
