package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_NUMBER_SEPARATOR = ",";
    private static final String LINE_BREAK = "\n";

    public static int getPurchaseAmount() {
        String userInput;

        System.out.println(ENTER_PURCHASE_AMOUNT);
        do {
            userInput = Console.readLine();
        } while (!validatePurchaseAmount(userInput));

        return Integer.parseInt(userInput);
    }

    private static boolean validatePurchaseAmount(String userInput) {
        try {
            InputException.canBeConvertedToInteger(userInput);
            InputException.isValidAmount(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static List<Integer> getWinningNumber() {
        String[] userInputs;
        System.out.println(LINE_BREAK + ENTER_WINNING_NUMBER);

        do {
            userInputs = Console.readLine().split(WINNING_NUMBER_SEPARATOR);
        } while (!handleWinningNumber(userInputs));

        return convertToInteger(userInputs);
    }

    private static boolean handleWinningNumber(String[] userInputs) {
        try {
            validateWinningNumber(userInputs);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void validateWinningNumber(String[] userInputs) {
        for (String userInput : userInputs) {
            InputException.canBeConvertedToInteger(userInput);
            InputException.isNumberInRange(userInput);
        }
        InputException.hasSixNumbers(userInputs);
        InputException.hasNoDuplicateNumbers(List.of(userInputs));
    }

    private static List<Integer> convertToInteger(String[] userInputs) {
        return Arrays.stream(userInputs)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int getBonusNumber(List<Integer> winningNumber) {
        String userInput;

        System.out.println(LINE_BREAK + ENTER_BONUS_NUMBER);
        do {
            userInput = Console.readLine();
        } while (!validateBonusNumber(winningNumber, userInput));

        return Integer.parseInt(userInput);
    }

    private static boolean validateBonusNumber(List<Integer> winningNumber, String userInput) {
        try {
            InputException.canBeConvertedToInteger(userInput);
            InputException.isNumberInRange(userInput);
            InputException.isInWinningNumbers(winningNumber, userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}