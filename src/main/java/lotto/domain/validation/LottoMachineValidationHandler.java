package lotto.domain.validation;

import static lotto.domain.validation.DefaultValidationMessage.*;

public class LottoMachineValidationHandler {
    public static final int MIN_LOTTO_GENERATE_COUNT = 1;
    public static final String INVALID_LOTTO_GENERATE_COUNT_MESSAGE = ERROR.getMessage() + " 로또는 최소 1장 이상 발행할 수 있습니다.";

    private LottoMachineValidationHandler() {
    }

    public static void validationMinGenerateLottoCount(int generateLottoCount) {
        if(!isMinGenerateLottoCount(generateLottoCount)) {
            throw new IllegalArgumentException(INVALID_LOTTO_GENERATE_COUNT_MESSAGE);
        }
    }

    private static boolean isMinGenerateLottoCount(int generateLottoCount) {
        return generateLottoCount >= MIN_LOTTO_GENERATE_COUNT;
    }
}
