package lotto.view;

import static lotto.constant.InputViewConstant.START_MESSAGE;
import static lotto.util.InputValidation.validateEmptyInput;
import static lotto.util.InputValidation.validateMoneyInput;
import static lotto.util.InputValidation.validationStringInput;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int inputMoney;

    public static void setStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static int setInputMoney() {
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = Console.readLine();
                validateEmptyInput(input);
                validationStringInput(input);

                inputMoney = Integer.parseInt(input);
                validateMoneyInput(inputMoney);

                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return inputMoney;
    }
}
