package lotto.validate;

import lotto.constants.ErrorMessage;

public class Validate {
    public void buyPriceValidate(String inputPrice) {
        inBlank(inputPrice);
        notNumber(inputPrice);
        underThousand(inputPrice);
        notThousandUnit(inputPrice);
    }

    private void inBlank(String inputString) {
        if (inputString.isBlank()) {
            System.out.println(ErrorMessage.ERROR_BLANK_MESSAGE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void notNumber(String inputString) {
        if (!inputString.matches("^[0-9]*$")) {
            System.out.println(ErrorMessage.ERROR_NOT_NUMBER_MESSAGE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void underThousand(String inputString) {
        if (inputString.length() < 4) {
            System.out.println(ErrorMessage.ERROR_UNDER_THOUSAND_MESSAGE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void notThousandUnit(String inputString) {
        if (!inputString.endsWith("000")) {
            System.out.println(ErrorMessage.ERROR_NOT_THOUSAND_UNITS_MESSAGE.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
