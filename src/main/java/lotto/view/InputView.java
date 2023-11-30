package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ExceptionMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String SEPARATOR = ",";
    private static final int MINIMUM_AMOUNT = 1;

    public static Integer inputPurchaseAmount() {
        try {
            return validatePositiveAmount(validateInteger(preprocessValidateIntegerAmount(Console.readLine())));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    public static List<Integer> inputWinningNumbers() {
        try {
            return separateWinningNumber(Console.readLine()).stream().map(winningNumber -> validateInteger(winningNumber)).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    public static Integer inputBonusNumber() {
        try {
            return validateInteger(Console.readLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    public static List<String> separateWinningNumber(String winningNumbers) {
        return Stream.of(winningNumbers.split(SEPARATOR)).map(String::trim).collect(Collectors.toList());
    }

    public static String preprocessValidateIntegerAmount(String playerPurchaseAmount) {
        return playerPurchaseAmount.trim().replace(SEPARATOR, "");
    }

    public static Integer validateInteger(String playerPurchaseAmount) {
        try {
            return Integer.valueOf(playerPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    public static Integer validatePositiveAmount(Integer playerPurchaseAmount) {
        if (playerPurchaseAmount < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITIVE_NUMBER_EXCEPTION_MESSAGE);
        }
        return playerPurchaseAmount;
    }

}