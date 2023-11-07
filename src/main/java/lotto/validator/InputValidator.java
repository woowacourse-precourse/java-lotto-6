package lotto.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public boolean isValidNumberRange(int input) {
        if ( input < LOTTO_NUMBER_START_INCLUSIVE.getValue() &&
                input > LOTTO_NUMBER_END_INCLUSIVE.getValue() ) {
            return false;
        }

        return true;
    }

    public boolean isValidNumberRange(List<Integer> input) {
        for (Integer element : input) {
            if (element < LOTTO_NUMBER_START_INCLUSIVE.getValue() &&
                    element > LOTTO_NUMBER_END_INCLUSIVE.getValue()) {
                return false;
            }
        }

        return true;
    }

    public boolean isVailidWinningNumberCount(List<Integer> input) {
        return input.size() == LOTTO_NUMBER_COUNT.getValue();
    }

    public boolean hasDuplicates(List<Integer> input) {
        List<Integer> existNumber = new ArrayList<>();

        for (Integer element : input) {
            if (existNumber.contains(element)) {
                return false;
            }

            existNumber.add(element);
        }

        return true;
    }
}
