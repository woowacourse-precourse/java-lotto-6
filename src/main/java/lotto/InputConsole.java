package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputConsole {

    public static int inputPrice() {
        String inputPrice = Console.readLine();
        validateInputPrice(inputPrice);
        return Integer.parseInt(inputPrice);
    }

    private static void validateInputPrice(String inputPrice) {
        for (int i = 0; i < inputPrice.length(); i++) {
            if (inputPrice.charAt(i) < '0' || inputPrice.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
        }
    }

    public static List<Integer> inputWinningNumbers() {
        String inputWinningNumber = Console.readLine();
        String inputWinningNumberNoSpace = inputWinningNumber.replaceAll(" ", "");
        String[] splittedWinningNumber = inputWinningNumberNoSpace.split(",");

        List<Integer> winningNumbers = new ArrayList<>();
        for (String inputNumber : splittedWinningNumber) {
            validateInputPrice(inputNumber);
            winningNumbers.add(Integer.parseInt(inputNumber));
        }

        return winningNumbers;
    }

}
