package lotto.validator;

import java.util.ArrayList;
import java.util.List;
import static lotto.utility.IntegerUtil.*;

public class InputValidator {

    public static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    public static boolean isDigit(String input) {
        return input.matches("\\d+");
    }

    public static boolean isDigit(String[] input) {
        for (String element : input) {
            if (!element.matches("\\d+")) {
                return false;
            }
        }

        return true;
    }

    public static boolean isMultipleOfUnit(int input) {
        return input % PAY_AMOUNT_UNIT.getValue() == 0;
    }

    public static boolean isValidNumberRange(int input) {
        if ( input < LOTTO_NUMBER_START_INCLUSIVE.getValue() &&
                input > LOTTO_NUMBER_END_INCLUSIVE.getValue() ) {
            return false;
        }

        return true;
    }

    public static boolean isValidNumberRange(List<Integer> input) {
        for (Integer element : input) {
            if (element < LOTTO_NUMBER_START_INCLUSIVE.getValue() &&
                    element > LOTTO_NUMBER_END_INCLUSIVE.getValue()) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValidNumberCount(List<Integer> input) {
        return input.size() == LOTTO_NUMBER_COUNT.getValue();
    }

    public static boolean hasDuplicates(List<Integer> input) {
        List<Integer> existNumber = new ArrayList<>();

        for (Integer element : input) {
            if (existNumber.contains(element)) {
                return true;
            }

            existNumber.add(element);
        }

        return false;
    }

    public static boolean hasDuplicatesInWinningNumber(List<Integer> winningNumber, int bonusNumber) {
        if ( winningNumber.contains(bonusNumber)) {
            return true;
        }

        return false;
    }
}
