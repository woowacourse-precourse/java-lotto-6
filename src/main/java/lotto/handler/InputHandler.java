package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validator;

import java.util.List;

public class InputHandler {
    private final Validator validator;
    public InputHandler(Validator validator) {
        this.validator = validator;
    }

    public int getAndValidatePayment() {
        while (true) {
            try {
                String userInput = Console.readLine();
                return validator.parseAndValidatePayment(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getAndTargetNumbers() {
        while (true) {
            try {
                String userInput = Console.readLine();
                return validator.parseAndValidateTargetNumbers(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getAndValidateBonusNumber(List<Integer> targetNumbers) {
        while (true) {
            try {
                String userInput = Console.readLine();
                int bonusNumber = validator.parseAndValidateBonusNumber(userInput);
                validator.checkDuplicateBonusNumber(targetNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
