package lotto.view.input;

import lotto.validator.AmountInputValidator;
import lotto.validator.InputValidator;
import lotto.view.Output;

public class AmountInput extends Input {

    private final static String INSTRUCTION_MESSAGE = "구입금액을 입력해 주세요.";

    @Override
    public String readLine() {
        Output.printMessage(INSTRUCTION_MESSAGE);
        return super.readLine();
    }

    @Override
    protected void validate(String input) {
        InputValidator validator = new AmountInputValidator();
        validator.validate(input);
    }
}
