package lotto.controller;

import java.util.Arrays;
import java.util.List;

public class Validator {

    public static final String DELEMTER = ",";
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int SIZE = 6;
    private static final int UNIT = 1000;

    public static boolean isBuyAmountValid(String playerInput) {
        try {
            int buyAmount = Integer.parseInt(playerInput);
            if (!isPlusInt(buyAmount) || !isThousandUnit(buyAmount)) {
                return false;
            }
        } catch (NumberFormatException e) {
            Exception.isNotNumber();
            return false;
        }
        return true;
    }

    public static boolean isValidAnswerLottoNumbers(String playerInput) {
        try {
            List<Integer> numbers = Arrays.stream(playerInput.split(DELEMTER)).map(Integer::parseInt)
                    .peek(Validator::isInOfRange).toList();

            if (!isSizeSix(numbers) || !isDistinct(numbers)) {
                return false;
            }
        } catch (NumberFormatException e) {
            Exception.isNotNumber();
            return false;
        }
        return true;
    }

    public static boolean isValidBonusNumber(List<Integer> answerLottoNumber, String playerInput) {
        try {
            int bonusNumber = Integer.parseInt(playerInput);
            if (bonusNumber < MIN_VALUE || bonusNumber > MAX_VALUE) {
                Exception.isOutOfRange();
            }

            if (answerLottoNumber.contains(bonusNumber)) {
                Exception.isNotDistinct();
            }

        } catch (NumberFormatException e) {
            Exception.isNotNumber();
        }
        return true;
    }

    private static boolean isPlusInt(int number) {
        if (number < MIN_VALUE) {
            Exception.isNotPlusInt();
            return false;
        }
        return true;
    }

    private static boolean isThousandUnit(int number) {
        if (number % UNIT != 0) {
            Exception.isNotThousandUnit();
            return false;
        }
        return true;
    }

    public static boolean isDistinct(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            Exception.isNotDistinct();
            return false;
        }
        return true;
    }

    public static boolean isSizeSix(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            Exception.isNotSixByComma();
            return false;
        }
        return true;
    }

    private static boolean isInOfRange(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            Exception.isOutOfRange();
            return false;
        }
        return true;
    }

}
