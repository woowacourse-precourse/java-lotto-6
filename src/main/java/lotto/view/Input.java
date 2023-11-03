package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;
import lotto.constant.InputMessage;
import lotto.domain.InputValidation;

public class Input {
    public static int readAmount() {
        int amount = 0;
        do {
            System.out.println(InputMessage.AMOUNT.getMessage());
            String input = Console.readLine();
            try {
                amount = InputValidation.checkNumber(input);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        while (amount == 0);
        return 1;
    }
}
