package lotto.util.validate;

import static lotto.util.constant.InvalidConstant.*;

public class DomainValidate {

    public static void validateOutOfRankingIndex(int rank) {
        if (rank >= 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + OUT_OF_RANKING_INDEX);
        }
    }

    public static void validateDivideByZero(int denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_DIVIDE_ZERO);
        }
    }
}
