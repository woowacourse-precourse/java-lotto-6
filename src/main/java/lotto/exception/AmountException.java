package lotto.exception;

import lotto.constant.Error;
import lotto.constant.LottoNumber;

public class AmountException {
    private final static int BILLION_DIGITS = 10;
    private final static int SAME = 0;
    private final static String MAX_INTEGER = "2147483647";

    public void checkBlank(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(Error.BLANK.getMessage());
        }
    }

    public void checkPositiveInteger(String input) {
        for(int index = 0; index < input.length(); index++) {
            if(input.charAt(index) < '0' || input.charAt(index) > '9') {
                throw new IllegalArgumentException(Error.NOT_INTEGER.getMessage());
            }
        }
    }

    public void checkOutOfIntegerRange(String input) {
        if (input.length() >= BILLION_DIGITS
                && input.compareTo(MAX_INTEGER) > SAME) {
            throw new IllegalArgumentException(Error.OUT_OF_INTEGER_RANGE.getMessage());
        }
    }

    public void checkLessThanMaxAmount(String input) {
        int amount = Integer.parseInt(input);

        if (amount < LottoNumber.MIN_AMOUNT.getValue()
                || amount > LottoNumber.MAX_AMOUNT.getValue()) {
            throw new IllegalArgumentException(Error.OUT_OF_MAX_AMOUNT.getMessage());
        }
    }

    public void checkEmptySpace(String input) {
        if(input.contains(" ")) {
            throw new IllegalArgumentException(Error.EMPTY_SPACE.getMessage());
        }
    }

    public void checkThousandUnits (String input) {
        int amount = Integer.parseInt(input);

        if (amount % LottoNumber.PRICE.getValue() != 0) {
            throw new IllegalArgumentException(Error.THOUSAND_UNITS.getMessage());
        }
    }
}
