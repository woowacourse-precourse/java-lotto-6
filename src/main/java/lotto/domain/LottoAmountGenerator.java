package lotto.domain;

import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.validation.LottoAmountValidator;

public class LottoAmountGenerator {
    private final static int UNIT = 1000;

    public static int generateLottoAmount() {
        while (true) {
            String input = InputHandler.askAmount();

            if (validate(input)) {
                int number = Integer.parseInt(input);
                return calculateAmount(number);
            }
        }
    }

    public static boolean validate(String input) {
        LottoAmountValidator validator = new LottoAmountValidator();
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

    public static int calculateAmount(int number) {
        return number / UNIT;
    }
}
