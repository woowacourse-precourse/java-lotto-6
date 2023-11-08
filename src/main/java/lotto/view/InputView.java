package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidation;

public class InputView {

    InputValidation inputValidation;

    public InputView(InputValidation inputValidation) {
        this.inputValidation = inputValidation;
    }

    public int inputPayment() {
        while (true) {
            try {
                String input = Console.readLine();
                inputValidation.isNumber(input);
                inputValidation.isThousandMultiple(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException error) {
                System.out.println(error);
            }
        }
    }
}
