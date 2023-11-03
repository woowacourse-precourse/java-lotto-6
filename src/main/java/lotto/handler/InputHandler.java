package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    private final Validator validator;

    public InputHandler(Validator validator) {
        this.validator = validator;
    }

    public int getPayment() {
        while (true) {
            try {
                String userInput = Console.readLine();
                return validator.parseAndValidatePayment(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getTargetNumbers() {
        while (true) {
            try {
                String userInput = Console.readLine();
                return validator.parseAndValidateTargetNumbers(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
