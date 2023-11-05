package lotto.domain;

import lotto.io.OutputHandler;
import lotto.validation.LottoCountValidator;

public class LottoAmount {
    public boolean validate(String input) {
        LottoCountValidator validator = new LottoCountValidator();
        try {
            validator.validate(input);
        } catch (IllegalArgumentException e) {
            handleError(e.getMessage());
            return false;
        }
        return true;
    }

    private void handleError(String message) {
        OutputHandler outputHandler = new OutputHandler();

        outputHandler.printErrorMessage(message);
    }
}
