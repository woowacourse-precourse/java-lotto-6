package lotto;

import java.util.Arrays;

import static lotto.utility.IntegerUtil.*;

public class InputValidator {

    public boolean isDigit(String input) {
        return input.matches("\\d+");
    }

    public boolean isDigit(String[] input) {
        for (String element : input) {
            if (!element.matches("\\d+")) {
                return false;
            }
        }

        return true;
    }

    public boolean isMultipleOfUnit(int input) {
        return input % PAY_AMOUNT_UNIT.getValue() == 0;
    }
}
