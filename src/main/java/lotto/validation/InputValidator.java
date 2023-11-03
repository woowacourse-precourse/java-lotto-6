package lotto.validation;

import lotto.constant.ErrorMessages;
import lotto.constant.NumberConstants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.NumberConstants.*;

public class InputValidator {

    public static boolean isNumeric(String str) {
        try {
            int number = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessages.PREFIX.getMessage()
                    + ErrorMessages.INVALID_TYPE.getMessage()
                    + ErrorMessages.SUFFIX.getMessage());
            return false;
        }
    }

    public static boolean isNumeric(String[] str) {
        try {
            for (String numeric : str) {
                int number = Integer.parseInt(numeric);
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessages.PREFIX.getMessage()
                    + ErrorMessages.INVALID_TYPE.getMessage()
                    + ErrorMessages.SUFFIX.getMessage());
            return false;
        }
    }

    public static boolean isInRange(List<Integer> winningNumbers) {
        return winningNumbers.stream().allMatch(n -> n >= LOTTO_NUMBER_MIN_RANGE.getValue()
                && n <= LOTTO_NUMBER_MAX_RANGE.getValue());
    }

    public static boolean isCalculate(int amount) {

        if (amount != 0 && amount % LOTTO_PRICE.getValue() == 0) {
            return true;
        }
        System.out.println(ErrorMessages.PREFIX.getMessage()
                + ErrorMessages.INVALID_AMOUNT.getMessage()
                + ErrorMessages.SUFFIX.getMessage());
        return false;
    }

    public static boolean isDuplicate(List<Integer> winningNumbers) {
        Set<Integer> numberSet = new HashSet<>();

        for (Integer num : winningNumbers) {
            if (numberSet.contains(num)) {
                return true;
            }
            numberSet.add(num);
        }
        return false;
    }

    public static boolean isSixNumber(List<Integer> winningNumbers) {
        return winningNumbers.size() == 6;
    }
}
