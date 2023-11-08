package lotto.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static lotto.constants.Constants.WINNING_NOT_VALID_FORMAT_MSG;
import static lotto.constants.Constants.WINNING_NOT_NUMBER_MSG;
import static lotto.constants.Constants.WINNING_NOT_VALID_RANGE_MSG;
import static lotto.constants.Constants.WINNING_HAS_DUPLICATE_MSG;

public class WinningNumberValidator {
    public static boolean validate(String winningNum) {
        String[] numbers = winningNum.split(",");
        if(isValidFormat(numbers));
        if(isNumbers(numbers));
        if(isValidNumbers(numbers));
        if(!hasDuplicatedNumbers(numbers));
        return true;
    }

    public static boolean isValidFormat(String[] numbers) {
        if(numbers.length!=6) {
            throw new IllegalArgumentException(WINNING_NOT_VALID_FORMAT_MSG);
        }
        return true;
    }
    public static boolean isNumbers(String[] numbers) {
        try{
            for(String num : numbers) {
                Integer.parseInt(num);
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNING_NOT_NUMBER_MSG);
        }
        return true;
    }
    public static boolean isValidNumbers(String[] numbers) {
        for(String num : numbers) {
            if(Integer.parseInt(num)<0 || 45<Integer.parseInt(num)) {
                throw new IllegalArgumentException(WINNING_NOT_VALID_RANGE_MSG);
            }
        }
        return true;
    }

    public static boolean hasDuplicatedNumbers(String[] numbers) {
        HashSet<String> num = new HashSet<>();
        for(String number : numbers) {
            num.add(number);
        }
        if(num.size()!=6) {
            throw new IllegalArgumentException(WINNING_HAS_DUPLICATE_MSG);
        }
        return false;
    }
}
