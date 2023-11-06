package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static lotto.OutputView.printRequestMoney;
import static lotto.OutputView.printWinningNumber;
import static lotto.OutputView.printBlankLine;
import static lotto.OutputView.printBonusNumber;

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

    public static Integer getBonusNumber() {
        printBonusNumber();
        String inputBonus = Console.readLine();
        printBlankLine();

        validateBlank(inputBonus);
        return validateNumeric(inputBonus);
    }

    private static int validateMoney(String inputMoney) {
        return validateNumeric(inputMoney);
    }

    private static void validateBlank(String inputMoney) {
        if (inputMoney.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static int validateNumeric(String inputNumber) {
        int number;
        try {
            number = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return number;
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
