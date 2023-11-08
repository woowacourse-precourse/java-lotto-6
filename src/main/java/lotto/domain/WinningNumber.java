package lotto.domain;

import lotto.utils.ErrorMessage;

public class WinningNumber {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    private final int winningNumber;

    public WinningNumber(final int winningNumber) {
        this.winningNumber = winningNumber;
    }

    public static WinningNumber createWinningNumber(final String number) {
        validateAtStringLevel(number);

        int convertedIntegerNumber = Integer.parseInt(number);
        sizeValidate(convertedIntegerNumber);

        return new WinningNumber(convertedIntegerNumber);
    }

    public boolean isNumberExist(final int number) {
        return winningNumber == number;
    }

    private static void validateAtStringLevel(final String number) {
        if (number.length() == 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_EMPTY.getErrorMessage());
        }

        try {
            Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.NON_INTEGER_VALUE.getErrorMessage());
        }
    }

    private static void sizeValidate(final int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.NON_WINNING_NUMBER.getErrorMessage());
        }
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof WinningNumber)) {
            return false;
        }

        WinningNumber objectWinningNumber = (WinningNumber) object;
        return objectWinningNumber.winningNumber == winningNumber;
    }

    @Override
    public int hashCode() {
        return winningNumber;
    }
}
