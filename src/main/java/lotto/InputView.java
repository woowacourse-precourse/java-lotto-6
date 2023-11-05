package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.OutputView.printRequestMoney;

public class InputView {
    public static int inputRequestMoney() {
        printRequestMoney();
        String inputMoney = Console.readLine();
        return validateNumber(inputMoney);
    }

    private static int validateNumber(String inputMoney) {
        inputBlank(inputMoney);
        return inputNumeric(inputMoney);
    }

    private static void inputBlank(String inputMoney) {
        if (inputMoney.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static int inputNumeric(String inputMoney) {
        int amount;
        try {
            amount = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return amount;
    }
}
