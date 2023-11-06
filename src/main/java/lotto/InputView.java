package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static lotto.OutputView.printRequestMoney;
import static lotto.OutputView.printWinningNumber;
import static lotto.OutputView.printBlankLine;

public class InputView {
    private static List<Integer> winningLotto;

    public static int inputRequestMoney() {
        printRequestMoney();
        String inputMoney = Console.readLine();
        validateBlank(inputMoney);
        return validateMoney(inputMoney);
    }

    public static List<Integer> getWinningNumber() {
        printWinningNumber();
        String inputResult = Console.readLine();
        printBlankLine();

        validateBlank(inputResult);
        return validateResult(inputResult);
    }

    private static int validateMoney(String inputMoney) {
        return validateMoneyNumeric(inputMoney);
    }

    private static void validateBlank(String inputMoney) {
        if (inputMoney.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static int validateMoneyNumeric(String inputMoney) {
        int amount;
        try {
            amount = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return amount;
    }

    private static List<Integer> validateResult(String inputWinningNumber) {
        List<String> winningNumbers = Arrays.asList(inputWinningNumber.split(","));
        for (String number : winningNumbers) {
            try {
                Integer winningNumber = Integer.parseInt(number);
                winningLotto.add(winningNumber);
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
        }

        return winningLotto;
    }
}
