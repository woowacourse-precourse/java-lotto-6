package lotto.util.validator;

import lotto.rule.LottoGameRule;
import lotto.util.exception.ErrorMessage;

public class LottoCostValidator {
    public static void validateLottoCostUnit(int lottoCost) {
        if (!(overMinLottoCost(lottoCost) && isZeroRemainder(lottoCost))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COST_UNIT.message());
        }
    }

    private static boolean overMinLottoCost(int lottoCost) {
        return lottoCost >= LottoGameRule.LOTTO_COST_UNIT.getConstant();
    }

    private static boolean isZeroRemainder(int lottoCost) {
        return (lottoCost % LottoGameRule.LOTTO_COST_UNIT.getConstant()) == 0;
    }
}
