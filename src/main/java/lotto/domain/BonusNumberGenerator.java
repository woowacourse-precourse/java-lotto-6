package lotto.domain;

import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.validation.LottoNumberValidator;

public class BonusNumberGenerator {
    public static int generateBonusNumber() {
        while (true) {
            String input = InputHandler.askBonusNumber();

            if (validate(input)) {
                return Integer.parseInt(input);
            }
        }
    }

    public static boolean validate(String input) {
        LottoNumberValidator validator = new LottoNumberValidator();
        try {
            validator.validate(input);
        } catch (IllegalArgumentException e) {
            handleError(e.getMessage());
            return false;
        }
        return true;
    }

    private static void handleError(String message) {
        OutputHandler.printErrorMessage(message);
    }
}
