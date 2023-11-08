package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

import static lotto.view.OutputView.printRequestMoney;
import static lotto.view.OutputView.printWinningNumber;
import static lotto.view.OutputView.printBonusNumber;

import static lotto.view.ErrorMessage.INVALID_FORMAT_ERROR;
import static lotto.view.ErrorMessage.EMPTY_INPUT_ERROR;

public class InputView {
    private static List<Integer> winningLotto = new ArrayList<>();

    public static int inputRequestMoney() {
        printRequestMoney();
        String inputMoney = Console.readLine();
        validateBlank(inputMoney);

        return validateMoney(inputMoney);
    }

    public static List<Integer> getWinningNumber() {
        printWinningNumber();
        String inputResult = Console.readLine();
        System.out.println();

        validateBlank(inputResult);

        return validateResult(inputResult);
    }

    public static Integer getBonusNumber() {
        printBonusNumber();
        String inputBonus = Console.readLine();
        System.out.println();

        validateBlank(inputBonus);

        return validateNumeric(inputBonus);
    }

    private static int validateMoney(String inputMoney) {
        return validateNumeric(inputMoney);
    }

    private static void validateBlank(String inputMoney) {
        if (inputMoney.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
    }

    private static int validateNumeric(String inputNumber) {
        int number = 0;

        try {
            number = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            System.out.println(INVALID_FORMAT_ERROR);
            inputRequestMoney();
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
                throw new NumberFormatException(INVALID_FORMAT_ERROR);
            }
        }

        return winningLotto;
    }
}
