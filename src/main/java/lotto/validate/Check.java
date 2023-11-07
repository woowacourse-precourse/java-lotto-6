package lotto.validate;

import lotto.util.ErrorMessage;

import java.util.List;

public class Check {

    private static final int Start_Number = 1;
    private static final int Final_Number = 45;

    public static void numberDuplicate(List<Integer> winningNumber, List<Integer> bonusNumber) {
        if (winningNumber.contains(bonusNumber.get(0))) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    public static void bonusNumberCount(List<Integer> winningNumber) {
        if (winningNumber.size() != 1) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_COUNT_ERROR.getMessage());
        }
    }

    public static void rightRange(List<Integer> winningNumber) {
        winningNumber.stream().filter(number -> number < Start_Number || number > Final_Number).forEach(number -> {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getMessage());
        });
    }
}