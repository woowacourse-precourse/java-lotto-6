package lotto.domain;

import lotto.constant.WinningMessage;
import org.assertj.core.util.TriFunction;

import static lotto.constant.ErrorMessage.PRICE_NEGATIVE;

/**
 * @param message          String to be formatted
 * @param reward           Amount of award
 * @param winningPredicate First Lotto: Checking ticket,
 *                         Second Lotto: Winning ticket,
 *                         LottoNumber: Bonus number
 */
public record Rank(WinningMessage message, long reward,
                   TriFunction<Lotto, Lotto, LottoNumber, Boolean> winningPredicate) {
    public Rank {
        validatePositiveReward(reward);
    }

    private static void validatePositiveReward(long reward) {
        if (reward < 0) {
            throw new IllegalArgumentException(PRICE_NEGATIVE);
        }
    }
}
