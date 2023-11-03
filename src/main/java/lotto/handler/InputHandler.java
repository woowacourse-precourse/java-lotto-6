package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validator;

public class InputHandler {
    private final Validator validator;

    public InputHandler(Validator validator) {
        this.validator = validator;
    }

    public int getPayment() {
        while (true) {
            try {
                String userInput = Console.readLine();
                validator.validatePayment(userInput);
                return Integer.parseInt(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
