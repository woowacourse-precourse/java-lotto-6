package lotto.model.calculator;

import static lotto.utils.constants.LottoConstants.MATCH_FIVE_AND_BONUS_PRICE;
import static lotto.utils.constants.LottoConstants.MATCH_FIVE_COUNT;
import static lotto.utils.constants.LottoConstants.MATCH_FIVE_PRICE;
import static lotto.utils.constants.LottoConstants.MATCH_FOUR_COUNT;
import static lotto.utils.constants.LottoConstants.MATCH_FOUR_PRICE;
import static lotto.utils.constants.LottoConstants.MATCH_SIX_COUNT;
import static lotto.utils.constants.LottoConstants.MATCH_SIX_PRICE;
import static lotto.utils.constants.LottoConstants.MATCH_THREE_COUNT;
import static lotto.utils.constants.LottoConstants.MATCH_THREE_PRICE;

import lotto.domain.result.MatchResult;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class ProfitCalculator {
    public static int calculateProfitPrice(MatchResult matchResult) {
        int totalProfit = 0;

        totalProfit += matchResult.getMatchCounts(MATCH_THREE_COUNT) * MATCH_THREE_PRICE;
        totalProfit += matchResult.getMatchCounts(MATCH_FOUR_COUNT) * MATCH_FOUR_PRICE;
        totalProfit += matchResult.getMatchCounts(MATCH_SIX_COUNT) * MATCH_SIX_PRICE;

        if (matchResult.getBonusMatchCount() == 0) {
            totalProfit += matchResult.getMatchCounts(MATCH_FIVE_COUNT) * MATCH_FIVE_PRICE;
        }

        totalProfit += matchResult.getBonusMatchCount() * MATCH_FIVE_AND_BONUS_PRICE;

        return totalProfit;
    }

    public static float calculateProfitPercentage(int totalProfit, int purchasePrice) {
        if (purchasePrice == 0) {
            throw LottoException.from(ErrorMessage.INVALID_PURCHASE_PRICE);
        }
        return (float) totalProfit / purchasePrice * 100;
    }
}
