package lotto.validate;

import static lotto.constants.ConstantValues.*;
import static lotto.constants.ErrorMessages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinNumberValidate {

    public static List<Integer> validateWinNumber(String winNumber) {
        validateWinNumberIsEmpty(winNumber);
        String[] winNumbers = splitWinNumber(winNumber);
        validateWinNumberLength(winNumbers);
        int[] winIntNumbers = validateWinNumberIsNumber(winNumbers);
        validateWinNumberIsRange(winIntNumbers);
        validateWinNumberIsNotDuplicate(winIntNumbers);
        return Arrays.asList(winIntNumbers[0], winIntNumbers[1], winIntNumbers[2], winIntNumbers[3], winIntNumbers[4],
                winIntNumbers[5]);
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

    public static int[] validateWinNumberIsNumber(String[] winNumbers) {
        int[] winIntNumbers = new int[winNumbers.length];
        for (String winNumber : winNumbers) {
            try {
                winIntNumbers[Arrays.asList(winNumbers).indexOf(winNumber)] = Integer.parseInt(winNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_HEADER.getMessage() + LOTTO_CHAR_ERROR.getMessage());
            }
        }
        return winIntNumbers;
    }

    public static void validateWinNumberIsRange(int[] winIntNumbers) {
        for (int winIntNumber : winIntNumbers) {
            if (winIntNumber < START_LOTTO_NUMBER.getValue() || winIntNumber > END_LOTTO_NUMBER.getValue()) {
                throw new IllegalArgumentException(ERROR_HEADER.getMessage() + LOTTO_RANGE_ERROR.getMessage());
            }
        }
    }

    public static void validateWinNumberIsNotDuplicate(int[] winIntNumbers) {
        ArrayList<Integer> winIntNumbersList = new ArrayList<>();
        for (int winIntNumber : winIntNumbers) {
            if (winIntNumbersList.contains(winIntNumber)) {
                throw new IllegalArgumentException(ERROR_HEADER.getMessage() + LOTTO_DUPLICATE_ERROR.getMessage());
            }
            winIntNumbersList.add(winIntNumber);
        }
    }

}
