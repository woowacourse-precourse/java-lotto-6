package lotto.view.input;

import lotto.validator.InputValidator;
import lotto.validator.NumberInputValidator;
import lotto.view.Output;

public class BonusNumberInput extends Input {

    private final static String INSTRUCTION_MESSAGE = "보너스 번호를 입력해 주세요.";

    @Override
    public String readLine() {
        Output.printMessage(INSTRUCTION_MESSAGE);
        return super.readLine();
    }

    @Override
    protected void validate(String input) {
        InputValidator validator = new NumberInputValidator();
        validator.validate(input);
    }
}
