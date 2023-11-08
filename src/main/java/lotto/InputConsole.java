package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputConsole {

    public static int inputPrice() {
        String inputPrice = Console.readLine();
        String inputPriceNoSpace = removeWhiteSpace(inputPrice);
        validateDigit(inputPriceNoSpace);
        return parseInt(inputPrice);
    }

    private static void validateDigit(String inputPrice) {
        for (int i = 0; i < inputPrice.length(); i++) {
            if (inputPrice.charAt(i) < '0' || inputPrice.charAt(i) > '9') {
                throw new IllegalArgumentException(ErrorCode.CONTAIN_NON_NUMERIC_CHARACTER.getMessage());
            }
        }
    }

    public static List<Integer> inputWinningNumbers() {
        String inputWinningNumber = Console.readLine();
        String inputWinningNumberNoSpace = removeWhiteSpace(inputWinningNumber);
        String[] splittedWinningNumber = inputWinningNumberNoSpace.split(",");

        List<Integer> winningNumbers = new ArrayList<>();
        for (String inputNumber : splittedWinningNumber) {
            validateDigit(inputNumber);
            winningNumbers.add(parseInt(inputNumber));
        }

        return winningNumbers;
    }

    public static int inputBonusNumber() {
        String inputBonusNumber = Console.readLine();
        String inputBonusNumberNoSpace = removeWhiteSpace(inputBonusNumber);
        validateDigit(inputBonusNumberNoSpace);
        return parseInt(inputBonusNumber);
    }

    public static String removeWhiteSpace(String input) {
        return input.replaceAll(" ", "");
    }

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.NOT_CONTAIN_NUMERIC_CHARACTER.getMessage());
        }
    }

}
