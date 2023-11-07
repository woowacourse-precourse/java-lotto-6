package lotto.domain.generator;

import lotto.io.InputHandler;
import lotto.validation.LottoNumberValidator;

public class BonusNumberGenerator implements Generator<String, Integer> {
    @Override
    public Integer generate() {
        while (true) {
            String input = InputHandler.askBonusNumber();

            if (validate(input)) {
                return Integer.parseInt(input);
            }
        }
    }

    @Override
    public boolean validate(String input) {
        LottoNumberValidator validator = new LottoNumberValidator();
        try {
            validator.validate(input);
        } catch (IllegalArgumentException e) {
            handleError(e.getMessage());
            return false;
        }
        return true;
    }
}
