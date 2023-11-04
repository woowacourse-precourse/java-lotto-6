package lotto.model.validator;

import lotto.common.config.LottoGameRule;
import lotto.common.exception.ErrorMessage;

public class LottoCostValidator extends InputValidator {
    public static void validateLottoCostUnit(int lottoCost) {
        if (!(overMinLottoCost(lottoCost) && isLottoCostUnit(lottoCost))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_THOUNSAND_UNIT_INPUT.message());
        }
    }

    private static boolean overMinLottoCost(int lottoCost) {
        return lottoCost >= LottoGameRule.LOTTO_COST_UNIT.constant();
    }

    private static boolean isLottoCostUnit(int lottoCost) {
        return (lottoCost / LottoGameRule.LOTTO_COST_UNIT.constant()) == 0;
    }
}
