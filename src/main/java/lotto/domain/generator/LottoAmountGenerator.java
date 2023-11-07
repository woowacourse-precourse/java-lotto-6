package lotto.domain.generator;

import lotto.io.InputHandler;
import lotto.validation.LottoAmountValidator;

public class LottoAmountGenerator implements Generator<String, Integer> {
    private final static int UNIT = 1000;

    @Override
    public Integer generate() {
        while (true) {
            String input = InputHandler.askAmount();

            if (validate(input)) {
                int number = Integer.parseInt(input);
                return calculateAmount(number);
            }
        }
    }

    @Override
    public boolean validate(String input) {
        LottoAmountValidator validator = new LottoAmountValidator();
        try {
            validator.validate(input);
        } catch (IllegalArgumentException e) {
            handleError(e.getMessage());
            return false;
        }
        return true;
    }
    
    public int calculateAmount(int number) {
        return number / UNIT;
    }
}
