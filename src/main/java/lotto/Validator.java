package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {


    public static void isValidAmount(String amount) {
        String INVALID_AMOUNT_ERROR_MESSAGE = "[ERROR] 자연수를 입력하세요";
        try {
            Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_AMOUNT_ERROR_MESSAGE);
        }
        if (Integer.parseInt(amount) < 1) {
            throw new IllegalArgumentException(INVALID_AMOUNT_ERROR_MESSAGE);
        }
    }

    public static void isAmountDivisibleBy1000(String amount) {
        String NOT_DIVISIBLE_BY_1000_ERROR_MESSAGE = "[ERROR] 1000원으로 나누어떨어지는 금액을 입력하세요";
        if (Integer.parseInt(amount) % 1000 != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_1000_ERROR_MESSAGE);
        }
    }

    public static void isWinningNumberValid(List<String> winningNumber) {
        for (String num : winningNumber) {
            validateNumberAndThrow(num);
        }
    }

    public static void isBonusNumberValid(String bonusNumber) {
        validateNumberAndThrow(bonusNumber);
    }

    public static void validateNumberAndThrow(String number) {
        String OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 1-45 사이의 수를 입력하세요";
        String INVALID_NUMBER_ERROR_MESSAGE = "[ERROR] 자연수를 입력하세요";

        try {
            int parseNum = Integer.parseInt(number);
            if (parseNum < 1 || parseNum > 46) {
                throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void isWinningNumberDistinct(List<String> winningNumber) {
        validateDistinctAndThrow(winningNumber);
    }

    public static void isBonusNumberDistinct(List<String> winningNumber, String bonusNumber) {
        List<String> lottoNumber = new ArrayList<>(winningNumber);
        lottoNumber.add(bonusNumber);

        validateDistinctAndThrow(lottoNumber);
    }

    public static void validateDistinctAndThrow(List<String> Number) {
        String NUMBER_NOT_DISTINCT_ERROR_MESSAGE = "[ERROR] 중복되지 않는 숫자를 입력하세요";

        Set<String> distinctNumbers = new HashSet<>();
        for (String num : Number) {
            if (!distinctNumbers.add(num)) {
                throw new IllegalArgumentException(NUMBER_NOT_DISTINCT_ERROR_MESSAGE);
            }
        }
    }

    public static void isNumberSizeValid(String[] number) {
        String INVALID_NUMBER_SIZE_ERROR_MESSAGE = "[Error] 당첨번호는 6개의 수를 입력하세요";
        if (number.length != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE_ERROR_MESSAGE);
        }
    }

}
