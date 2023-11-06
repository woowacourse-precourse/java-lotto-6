package lotto.exception;

public class LottoNumberException {
    private final static int BILLION_DIGITS = 10;
    private final static int SAME = 0;

    public boolean isPositiveInteger(String input) {
        for(int index = 0; index < input.length(); index++) {
            if(input.charAt(index) < '0' || input.charAt(index) > '9') {
                return false;
            }
        }

        return true;
    }

    public boolean isOutOfIntegerRange(String number) {
        if (number.length() > BILLION_DIGITS
                || number.compareTo("2147483647") > SAME) {
            return true;
        }

        return false;
    }
}
