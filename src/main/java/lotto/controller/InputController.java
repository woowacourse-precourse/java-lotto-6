package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputController {
    private final InputValidator inputValidator;

    public InputController(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    // Input : 1090 / Result : [ERROR] 출력 이후 다시 데이터 받음
    public int inputAmountType() {
        String input = Console.readLine();
        int amount = 0;
        try {
            inputValidator.validateInputType(input);
            amount = Integer.parseInt(input);
            inputValidator.validateInputData(amount);
        } catch (IllegalArgumentException e) {
            inputAmountType();
        }
        return amount;
    }
}
