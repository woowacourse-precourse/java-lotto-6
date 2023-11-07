package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.input.validator.InputBonusValidator;
import lotto.input.validator.InputLottoValidator;

public class InputBonus {
    private static final String MESSAGE_INPUT_BONUS = "보너스 번호를 입력해 주세요.";

    private InputBonusValidator inputBonusValidator = InputBonusValidator.getInstance();

    private boolean isError = true;
    private String input = "";

    public String getUserInput() {
        System.out.println(MESSAGE_INPUT_BONUS);
        do {
            input = Console.readLine();
            try {
                inputBonusValidator.validate(input);
                isError = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (isError == true);
        return input;
    }
}
