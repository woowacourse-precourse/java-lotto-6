package lotto.domain.result;

import static lotto.domain.constants.LottoConstants.MATCH_FIVE_AND_BONUS_COUNT;
import static lotto.domain.constants.LottoConstants.MATCH_FIVE_AND_BONUS_PRICE;
import static lotto.domain.constants.LottoConstants.MATCH_FIVE_COUNT;
import static lotto.domain.constants.LottoConstants.MATCH_FIVE_PRICE;
import static lotto.domain.constants.LottoConstants.MATCH_FOUR_COUNT;
import static lotto.domain.constants.LottoConstants.MATCH_FOUR_PRICE;
import static lotto.domain.constants.LottoConstants.MATCH_SIX_COUNT;
import static lotto.domain.constants.LottoConstants.MATCH_SIX_PRICE;
import static lotto.domain.constants.LottoConstants.MATCH_THREE_COUNT;
import static lotto.domain.constants.LottoConstants.MATCH_THREE_PRICE;

public class LottoCalculateResult {
    private int profitPrice;
    private float profitPercent;

    public float getProfitPercent() {
        return profitPercent;
    }

    public void calculateProfitPrice(LottoMatchResult lottoMatchResult) {
        this.profitPrice = 0;

        if (lottoMatchResult.getBonusMatchCount() > 0) {
            int countFiveAndBonus = lottoMatchResult.getMatchCounts(MATCH_FIVE_AND_BONUS_COUNT);
            this.profitPrice += countFiveAndBonus * MATCH_FIVE_AND_BONUS_PRICE;
        }

        int countThreeMatches = lottoMatchResult.getMatchCounts(MATCH_THREE_COUNT);
        int countFourMatches = lottoMatchResult.getMatchCounts(MATCH_FOUR_COUNT);
        int countFiveMatches = lottoMatchResult.getMatchCounts(MATCH_FIVE_COUNT);
        int countSixMatches = lottoMatchResult.getMatchCounts(MATCH_SIX_COUNT);

        this.profitPrice += countThreeMatches * MATCH_THREE_PRICE;
        this.profitPrice += countFourMatches * MATCH_FOUR_PRICE;
        this.profitPrice += countFiveMatches * MATCH_FIVE_PRICE;
        this.profitPrice += countSixMatches * MATCH_SIX_PRICE;
    }

    public void calculateProfitPercentage(LottoPurchaseResult purchaseResult) {
        int purchasePrice = purchaseResult.getPurchase().getPurchasePrice();
        this.profitPercent = (float) profitPrice / purchasePrice * 100;
    }
}
