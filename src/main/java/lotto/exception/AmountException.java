package lotto.exception;

import lotto.constant.ErrorText;
import lotto.constant.LottoRule;

public class AmountException {
    private final static int BILLION_DIGITS = 10;
    private final static int SAME = 0;
    private final static String MAX_INTEGER = "2147483647";

    public void checkBlank(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorText.BLANK.getMessage());
        }
    }

    public void checkPositiveInteger(String input) {
        for(int index = 0; index < input.length(); index++) {
            if(input.charAt(index) < '0' || input.charAt(index) > '9') {
                throw new IllegalArgumentException(ErrorText.NOT_INTEGER.getMessage());
            }
        }

        if (Integer.parseInt(input) == 0) {
            throw new IllegalArgumentException(ErrorText.NOT_INTEGER.getMessage());
        }
    }

    public void checkOutOfIntegerRange(String input) {
        if (input.length() >= BILLION_DIGITS
                && input.compareTo(MAX_INTEGER) > SAME) {
            throw new IllegalArgumentException(ErrorText.OUT_OF_INTEGER_RANGE.getMessage());
        }
    }

    public void checkLessThanMaxAmount(String input) {
        int amount = Integer.parseInt(input);

        if (amount < LottoRule.MIN_AMOUNT.getValue()
                || amount > LottoRule.MAX_AMOUNT.getValue()) {
            throw new IllegalArgumentException(ErrorText.OUT_OF_MAX_AMOUNT.getMessage());
        }
    }

    public void checkEmptySpace(String input) {
        if(input.contains(" ")) {
            throw new IllegalArgumentException(ErrorText.EMPTY_SPACE.getMessage());
        }
    }

    public void checkThousandUnits (String input) {
        int amount = Integer.parseInt(input);

        if (amount % LottoRule.PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorText.THOUSAND_UNITS.getMessage());
        }
    }
}
