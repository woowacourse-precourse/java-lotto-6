package lotto.validate;

import static lotto.constants.ConstantValues.*;
import static lotto.constants.ErrorMessages.*;

import java.util.ArrayList;
import java.util.Arrays;

public class WinNumberValidate {

    public static void validateWinNumber(String winNumber) {
        validateWinNumberIsEmpty(winNumber);
        String[] winNumbers = splitWinNumber(winNumber);
        validateWinNumberLength(winNumbers);
        validateWinNumberIsNumber(winNumbers);
        validateWinNumberIsRange(winNumbers);
        validateWinNumberIsNotDuplicate(winNumbers);

    }

    public static void validateWinNumberIsEmpty(String winNumber) {
        if (winNumber.isEmpty()) {
            throw new IllegalArgumentException(ERROR_HEADER.getMessage() + LOTTO_EMPTY_ERROR.getMessage());
        }
    }

    public static String[] splitWinNumber(String winNumber) {
        return winNumber.split(",");
    }

    public static void validateWinNumberLength(String[] winNumbers) {
        if (winNumbers.length != LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException(ERROR_HEADER.getMessage() + LOTTO_LENGTH_ERROR.getMessage());
        }
    }

    public static void validateWinNumberIsNumber(String[] winNumbers) {
        for (String winNumber : winNumbers) {
            try {
                Integer.parseInt(winNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_HEADER.getMessage() + LOTTO_CHAR_ERROR.getMessage());
            }
        }
    }

    public static void validateWinNumberIsRange(String[] winNumbers) {
        for (String winNumber : winNumbers) {
            int number = Integer.parseInt(winNumber);
            if (number < START_LOTTO_NUMBER.getValue() || number > END_LOTTO_NUMBER.getValue()) {
                throw new IllegalArgumentException(ERROR_HEADER.getMessage() + LOTTO_RANGE_ERROR.getMessage());
            }
        }
    }

    public static void validateWinNumberIsNotDuplicate(String[] winNumbers) {
        ArrayList<String> winNumberList = new ArrayList<>(Arrays.asList(winNumbers));
        for (String winNumber : winNumbers) {
            winNumberList.remove(winNumber);
            if (winNumberList.contains(winNumber)) {
                throw new IllegalArgumentException(ERROR_HEADER.getMessage() + LOTTO_DUPLICATE_ERROR.getMessage());
            }
        }
    }

}
