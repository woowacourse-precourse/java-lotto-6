package lotto.view.input;

import lotto.validator.InputValidator;
import lotto.validator.LottoInputValidator;

public class LottoAnswerInput extends Input {

    @Override
    protected void validate(String input) {
        InputValidator validator = new LottoInputValidator();
        validator.validate(input);
    }
}
