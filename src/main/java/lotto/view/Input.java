package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;
import lotto.constant.InputMessage;
import lotto.domain.InputValidation;

public class Input {
    private static int validateAmount(String input) {
        int amount;
        try {
            amount = InputValidation.checkNumber(input);
            InputValidation.checkDivisible(amount);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            amount = 0;
        }
        return amount;
    }

    public static Integer readAmount() {
        int amount;
        do {
            System.out.println(InputMessage.AMOUNT.getMessage());
            amount = validateAmount(Console.readLine());
        }
        while (amount == 0);
        return amount;
    }
}
