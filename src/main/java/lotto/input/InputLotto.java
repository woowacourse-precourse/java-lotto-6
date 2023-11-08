package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.input.validator.InputLottoValidator;

public class InputLotto {
    private static final String MESSAGE_INPUT_LOTTO = "당첨 번호를 입력해 주세요.";

    private InputLottoValidator inputLottoValidator = InputLottoValidator.getInstance();

    private String input = "";

    public String getUserInput() {
        System.out.println(MESSAGE_INPUT_LOTTO);
        input = Console.readLine();
        validate(input);
        return input;
    }

    private void validate(String input) {
        inputLottoValidator.validate(input);
    }
}
