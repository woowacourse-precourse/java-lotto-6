package lotto.util.validator;

import lotto.config.GameConfig;

public class LottoNumberValidator {

    private LottoNumberValidator() {
    }

    public static void validate(int number) {
        if (number < GameConfig.LOTTO_MIN_NUMBER || number > GameConfig.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
