package exception;

import static config.ErrorMessage.*;
import static config.LottoConst.*;

import java.util.regex.Pattern;

public class InputException {

    private static final String NUMBER_REGEX = "[0-9]+";
    private static final int STANDARD_NUMBER = 0;
    private static final Pattern regex = Pattern.compile(NUMBER_REGEX);

    private InputException() {
    }

    public static int validateInteger(String pay) {
        if (regex.matcher(pay).matches()) {
            return Integer.parseInt(pay);
        }
        throw new IllegalArgumentException(ONLY_NUMBER.getMessage());
    }

    public static int validatePayUnit(int pay) {
        if (pay > STANDARD_NUMBER && pay % PRICE_MIN_UNIT.getNumber() == STANDARD_NUMBER) {
            return pay;
        }
        throw new IllegalArgumentException(PRICE.getMessage());
    }

    public static int validateRange(int number) {
        if (number < RANGE_START.getNumber() || number > RANGE_END.getNumber()) {
            throw new IllegalArgumentException(RANGE.getMessage());
        }
        return number;
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
